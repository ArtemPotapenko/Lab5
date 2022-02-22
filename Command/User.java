package Command;

import RouteDir.*;

import java.io.File;
import java.util.LinkedHashSet;

public class User {
    private static void help_print_for_command(Command command) {
        System.out.println(command.getName() + (command.HaveArgument() ? " " + ((CommandsWithArgument<?>) command).getArgument_name() + " " : " ") + ": " + command.ru_description());
    }

    private Command add;
    private Command show;
    private Command add_if_max;
    private Command clear;
    private Command exit;
    private Command info;
    private Command max_by_to;
    private Command print_desceding;
    private Command print_fiel;
    private Command remove;
    private Command remove_greater;
    private Command save;
    private Command update;
    private Command help;
    private Command history;
    private Command execute;
    private Command[] commands;
    public User(File file, LinkedHashSet<Route> routes,Command help, Command info, Command show, Command add, Command update, Command remove_by_id,
                Command clear, Command save,Command execute_script ,Command exit, Command add_if_max, Command remove_greater,Command history,
                Command max_by_to, Command print_descending, Command print_field_ascending_distance) {
        this.add=add;
        this.add.setName("add");
        this.help=help;
        this.help.setName("help");
        this.add_if_max =add_if_max;
        this.add_if_max.setName("add_if_max");
        this.update=update;
        this.update.setName("update");
        this.clear=clear;
        this.clear.setName("clear");
        this.max_by_to=max_by_to;
        this.max_by_to.setName("max_by_to");
        this.history=history;
        this.history.setName("history");
        this.exit=exit;
        this.exit.setName("exit");
        this.print_fiel=print_field_ascending_distance;
        this.print_fiel.setName("print_field_ascending_distance");
        this.remove_greater=remove_greater;
        this.remove_greater.setName("remove_greater");
        this.info=info;
        this.info.setName("info");
        this.remove=remove_by_id;
        this.remove.setName("remove_by_id");
        this.save=save;
        this.save.setName("save");
        this.show=show;
        this.show.setName("show");
        this.print_desceding=print_descending;
        this.print_desceding.setName("print_descending");
        this.execute = execute_script;
        this.execute.setName("execute_script");
        this.commands = new Command[]{this.add, this.add_if_max, this.clear, this.exit, this.info, this.max_by_to, this.print_desceding,
                this.print_fiel, this.remove, this.remove_greater, this.save, this.update, this.execute,this.help,this.show,this.history};




    }
    public void add(){
        add.execute();
    };
    public void show(){
        show.execute();
    };
    public void add_if_max(){
        add_if_max.execute();
    };
    public void clear(){
        clear.execute();
    };
    public void exit(){
        exit.execute();
    };
    public void info(){
        info.execute();
    };
    public void max_by_to(){
        max_by_to.execute();
    };
    public void print_desceding(){
        print_desceding.execute();
    };
    public void print_field_ascending_distance(){
        print_fiel.execute();
    }
    public void remove_by_id(){
        remove.execute();
    };
    public void remove_greater(){
        remove_greater.execute();
    };
    public void save(){
        save.execute();
    };
    public void update(){
        update.execute();
    };
    public void help(){
        help.execute();
    };
    public void history(){
        history.execute();
    };
    public void execute(){
        execute.execute();
    };

    public Command[] getCommands() {
        return this.commands;
    }
}
