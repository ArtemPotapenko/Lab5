package Command;

import RouteDir.*;

import java.io.File;
import java.util.LinkedHashSet;

public abstract class CommandsWithArgument<T> extends Commands {
    protected T argument ;
    protected String argument_name;

    public CommandsWithArgument(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public boolean HaveArgument(){
        return true;
    }
    public void setArgument(T argument) {
        this.argument = argument;
    }

    public T getArgument() {
        return argument;
    }

    public String getArgument_name() {
        return argument_name;
    }
    public void String_to_Arg(String s){
        this.setArgument((T) s);
    }


}
