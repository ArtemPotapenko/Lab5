package Command;

import RouteDir.Route;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);
    }

    @Override
    public String ru_description() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}
