package command;

import routedir.Route;

import java.io.File;
import java.util.*;

/**
 * Добавить элемент если он больше всех элементов массива.
 * Элементы сравниваются по имени.
 * @version 1.0
 */
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
            System.out.println("Элемент добавлен");

        }else {
            System.out.println("Элемент не добавлен");
        }
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);}

    @Override
    public String ru_description() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

}
