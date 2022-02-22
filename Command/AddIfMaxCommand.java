package Command;

import RouteDir.Route;

import java.io.File;
import java.util.*;

public class AddIfMaxCommand extends Commands{

    public AddIfMaxCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        long my_id=1;
        Set<Long> S_id = new HashSet<>();
        routes.forEach(x->S_id.add(x.getId()));
        while (S_id.contains(my_id)){my_id++;}
        Route route = new Route(my_id);

        if (route.compareTo(Collections.max(routes))>0){
            routes.add(route);

        }
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);}

    @Override
    public String ru_description() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

}
