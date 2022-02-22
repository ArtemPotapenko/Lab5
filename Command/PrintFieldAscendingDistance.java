package Command;

import RouteDir.Route;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class PrintFieldAscendingDistance extends Commands {

    public PrintFieldAscendingDistance(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        List<Route> routeSorted = new ArrayList<>(routes);
        Collections.sort(routeSorted , (x,y)->x.getDistance().compareTo(y.getDistance()));
        System.out.println();
        routeSorted.forEach(x-> System.out.print(x.getDistance()+" "));

    }

    @Override
    public String ru_description() {
        return  "вывести значения поля distance всех элементов в порядке возрастания";
    }
}
