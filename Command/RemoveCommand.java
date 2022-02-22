package Command;

import RouteDir.*;
import Exception.*;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class RemoveCommand extends CommandsWithArgument<Long> {

    public RemoveCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
        argument_name ="id";

    }

    @Override
    public void execute() {
        boolean ok=false;
        for (Route x: routes){
            if (argument.equals(x.getId())) {
                ok = true;
                routes.remove(x);
                break;
            }
        }
        if (!ok){
            throw new IDException("Элемента с этим ID нет в списке.");
        }
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);


    }

    @Override
    public String ru_description() {
        return "удалить элемент из коллекции по его id";

    }

    @Override
    public void String_to_Arg(String s) {
        this.setArgument(Long.parseLong(s));
    }
}
