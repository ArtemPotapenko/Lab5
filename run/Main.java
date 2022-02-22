package run;


import Command.*;
import RouteDir.*;
import run.ParseCSV;


import java.io.*;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String hat_table = "id, name, x-coord, y_coord,Date, to class, to_x, to_y, to_z, from class, from_x," +
                "from_y, from_z, distance, spaec_id";

        String file_name = args[0];//args[0], обработать
        File file = new File(file_name);
        if (!file.isFile()){
            file.createNewFile();
            PrintWriter out_file = new PrintWriter(file);
            out_file.println(hat_table);
            out_file.close();
        }else if(!file.canRead() || !file.canWrite()){
            System.out.println("Недостаточно прав у файла для работы программы.");
            System.exit(0);
        }

        LinkedHashSet<Route> a=new LinkedHashSet<>();
        Scanner in_file=new Scanner(file);
        try{
        String t=in_file.nextLine();
        while (in_file.hasNext()){
            a.add(ParseCSV.parse_csv_to_route(in_file.nextLine()));

        }
        }catch (NoSuchElementException | NumberFormatException e  ){
            System.out.println("Файл не подходит под формат даннных. Пожайлуйста, либо введите имя подходящего файла, либо имя несуществующего файла для создания нового. ");
            System.exit(0);
        }
        Scanner in=new Scanner(System.in);
        ReedFunction reed = new ReedFunction();
        User user = new User(file,a,new HelpCommand(a,file),new InfoCommand(a,file),new ShowCommand(a,file),new AddCommand(a,file)
        , new UpdateCommand(a,file),new RemoveCommand(a,file),new ClearCommand(a,file),new SaveCommand(a,file),
               reed.new ExecuteCommand(a,file), new ExitCommand(a,file),new AddIfMaxCommand(a,file),new RemoveCommand(a,file),
                reed.new HistoryCommand(a,file),new MaxByToCommand(a,file),new PrintDescendingCommand(a,file),new PrintFieldAscendingDistance(a,file));
        reed.setCommands(user.getCommands());
        while (true){
            System.out.println();
            reed.reed(in.nextLine());

        }


        }}

