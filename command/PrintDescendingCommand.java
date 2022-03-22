package command;

import routedir.Route;

import java.io.File;
import java.util.*;

/**
 * Вывод в обратном порядке
 * @version 1.0
 */
public class PrintDescendingCommand extends Commands{
    public PrintDescendingCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        List<Route> routeSorted = new ArrayList<>(routes);
        Collections.sort(routeSorted,(x,y)-> y.compareTo(x));
        routeSorted.forEach(x->x.ShowPrint());
        if (routes.size()==0){
            System.out.println("В списке нет элементов");
        }

    }

    @Override
    public String ru_description() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
