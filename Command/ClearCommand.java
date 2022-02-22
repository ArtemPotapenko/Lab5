package Command;

import RouteDir.Route;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;

public class ClearCommand extends Commands{
    public ClearCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        routes.removeAll(routes);
    }

    @Override
    public String ru_description() {
        return "очистить коллекцию";
    }
}
