package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Вывести список команд
 * @version 1.0
 */
public class HelpCommand extends CommandsUseArray{
    public HelpCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }
    private static void help_print_for_command(Command command) {
        System.out.println(command.getName() + (command.HaveArgument() ? " " + ((CommandsWithArgument<?>) command).getArgument_name() + " " : " ") + ": " + command.ru_description());
    }

    @Override
    public void execute() {
        Command[] commands=getCommands();
        for(Command x:commands){
            help_print_for_command(x);
        }

    }

    @Override
    public String ru_description() {
        return "вывести справку по доступным командам";
    }
}
