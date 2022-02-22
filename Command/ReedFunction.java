package Command;

import RouteDir.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;
import Exception.IDException;

public class ReedFunction {
    Command[] commands;
    Deque<Command> Last_comands=new LinkedList<Command>();

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    /**
     *
     * @param s
     * reed and run command
     */
    public void reed(String s) {
        boolean ok=false;
        String[] S = s.split(" ");
        String command_name=S[0];
        Command ok_com = null;
        for (Command x:commands){Pattern pattern=Pattern.compile(x.getName());
        if (pattern.matcher(command_name).matches()){
            if (x.HaveArgument()){
                try{
                CommandsWithArgument<?> command_arg=(CommandsWithArgument<?>) x;
                command_arg.String_to_Arg(S[1]);
                command_arg.execute();
                ok=true;
                ok_com=command_arg;}
                catch (IDException e){
                    System.out.println("Неверный ввод аргумента.");
                }
            }
            else {ok=true;
                ok_com=x;
                if (x.NeedCommands()){
                    CommandsUseArray command_with_arr= (CommandsUseArray) x;
                    command_with_arr.setCommands(commands);
                    command_with_arr.execute();
                }
                else{
            x.execute();}}

        }
        }



        if(ok==false){
            System.out.println("Неправильный ввод команды или аргумента");
        }
        if(ok==true){
            Last_comands.addFirst(ok_com);
        }
    }
    public class HistoryCommand extends Commands{



        public HistoryCommand(LinkedHashSet<Route> routes, File file) {
            super(routes, file);
        }

        @Override
        public void execute() {
            if (ReedFunction.this.Last_comands.size()<9){
                Last_comands.forEach(x-> System.out.println(x));

            }else {
                int i=0;
                for (Command x:Last_comands){
                    i++;
                    System.out.println(x);
                    if (i==9){break;}
                }
            }
        }

        @Override
        public String ru_description() {
            return "вывести последние 9 команд (без их аргументов)";
        }
    }
        public class ExecuteCommand extends CommandsWithArgument<String>{

        public ExecuteCommand(LinkedHashSet<Route> routes, File file) {
            super(routes, file);
            argument_name ="file_name";
        }



            @Override
            public void execute() {
                try {
                    Scanner in_script = new Scanner(new File(argument));
                    while (in_script.hasNext()){
                        reed(in_script.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Файл со скриптом не найден");
                }


            }

            @Override
        public String ru_description() {
            return "считать и исполнить скрипт из указанного файла.";
        }
    }

}
