package Command;


import java.io.File;
import java.util.LinkedHashSet;

import RouteDir.*;
public abstract class Commands implements Command{
    protected LinkedHashSet<Route> routes;
    File file;
    public Commands( LinkedHashSet<Route> routes, File file){
        this.routes=routes;
        this.file=file;
    }
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean HaveArgument(){
        return false;
    }

    @Override
    public boolean NeedCommands() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
