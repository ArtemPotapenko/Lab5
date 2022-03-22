package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Удалить все большие елементы.
 */
public class RemoveGreater extends Commands{
    public RemoveGreater(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        Route route = new Route();
        for (Route x: routes){
            if (x.compareTo(route)>0){
                routes.remove(x);
            }
        }
        System.out.println("Элементы удалены.");
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);
    }

    @Override
    public String ru_description() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}
