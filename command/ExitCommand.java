package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Закрыть программу
 * @version 1.0
 */
public class ExitCommand extends Commands{
    public ExitCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        System.exit(0);

    }

    @Override
    public String ru_description() {
        return "завершить программу (без сохранения в файл)";
    }
}
