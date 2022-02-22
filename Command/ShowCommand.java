package Command;

import RouteDir.Route;

import java.io.File;
import java.util.LinkedHashSet;

public class ShowCommand extends Commands{
    public ShowCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        routes.forEach(x-> System.out.println(x));

    }

    @Override
    public String ru_description() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
