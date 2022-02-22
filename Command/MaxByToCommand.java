package Command;

import RouteDir.Route;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;

public class MaxByToCommand extends Commands{
    public MaxByToCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        System.out.println(Collections.max(routes,(x,y)->x.getTo().compareTo(y.getTo())));

    }

    @Override
    public String ru_description() {
        return "вывести любой объект из коллекции, значение поля to которого является максимальным";
    }
}
