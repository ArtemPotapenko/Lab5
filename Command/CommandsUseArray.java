package Command;

import RouteDir.Route;

import java.io.File;
import java.util.LinkedHashSet;

public abstract class CommandsUseArray extends Commands{
    private Command[] commands;


    public CommandsUseArray(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }



    public Command[] getCommands() {
        return commands;
    }

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public boolean NeedCommands() {
        return true;
    }
}
