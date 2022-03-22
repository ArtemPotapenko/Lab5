package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Очистка коллекции
 * @version 1.0
 */
public class ClearCommand extends Commands{
    public ClearCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        routes.removeAll(routes);
        System.out.println("Список очищен");
    }

    @Override
    public String ru_description() {
        return "очистить коллекцию";
    }
}
