package Command;

import RouteDir.Route;

import java.io.File;
import java.util.*;

public class PrintDescendingCommand extends Commands{
    public PrintDescendingCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        List<Route> routeSorted = new ArrayList<>(routes);
        Collections.sort(routeSorted,(x,y)-> y.compareTo(x));
        routeSorted.forEach(x-> System.out.println(x));

    }

    @Override
    public String ru_description() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
