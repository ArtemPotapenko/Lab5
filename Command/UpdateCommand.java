package Command;

import RouteDir.Route;
import Exception.*;
import java.io.File;
import java.util.*;


public class UpdateCommand extends CommandsWithArgument<Long>{
    public UpdateCommand(LinkedHashSet<Route> routes, File file) {
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
        if (ok){
        Route route = new Route(argument);
        routes.add(route);}
        else{
            throw new IDException("Элемента с этим ID нет в списке");
        }
        TreeSet<Route> routeSorted = new TreeSet<>(routes);
        routes.removeAll(routes);
        routes.addAll(routeSorted);
    }

    @Override
    public String ru_description() {
        return  "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void String_to_Arg(String s) {
        this.setArgument(Long.parseLong(s));
    }
}
