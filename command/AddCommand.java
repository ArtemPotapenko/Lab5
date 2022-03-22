package command;

import routedir.*;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Доьавить элемент
 * @version 1.0
 */
public class AddCommand extends Commands{


    public AddCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        long my_id=1;
        Set<Long> S_id = new HashSet<>();
        routes.forEach(x->S_id.add(x.getId()));
        while (S_id.contains(my_id)){my_id++;}
        Route route = new Route(my_id);
        routes.add(route);
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);
        System.out.println("Элемент добавлен");

    }

    @Override
    public String ru_description() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public boolean HaveArgument() {
        return false;
    }


}
