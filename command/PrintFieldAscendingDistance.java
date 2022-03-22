package command;

import routedir.Route;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Вывод отсортированный полей дистанции.
 * @version 1.0
 */
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
        if(routeSorted.size()==0){System.out.println("В списке нет элементов");}

    }

    @Override
    public String ru_description() {
        return  "вывести значения поля distance всех элементов в порядке возрастания";
    }
}
