package Command;

import RouteDir.Route;

import java.io.File;
import java.util.LinkedHashSet;

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
