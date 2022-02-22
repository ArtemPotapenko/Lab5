package Command;


import RouteDir.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

import run.ParseCSV;


public class SaveCommand extends Commands {

    public SaveCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        try {
            PrintWriter out_file = new PrintWriter(file);
            out_file.println("id, name, x-coord, y_coord,Date, to class, to_x, to_y, to_z, from class, from_x, from_y, from_z, distance, spaec_id");
            routes.forEach(x->out_file.println(ParseCSV.parse_route_to_csv(x)));
            out_file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String ru_description() {
        return "сохранить коллекцию в файл";
    }



}
