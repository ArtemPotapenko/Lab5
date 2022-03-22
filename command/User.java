package command;

import routedir.*;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Класс пользователя. Для работы с его командами взаимодейтсвия
 * @version 1.0
 * @see Command
 * @see Commands
 */
public class User {
    private static void help_print_for_command(Command command) {
        System.out.println(command.getName() + (command.HaveArgument() ? " " + ((CommandsWithArgument<?>) command).getArgument_name() + " " : " ") + ": " + command.ru_description());
    }

    /**
     * Пользовательская команда add
     */
    private Command add;
    /**
     * Пользовательская команда show
     */
    private Command show;
    /**
     * Пользовательская команда add_if_max
     */
    private Command add_if_max;
    /**
     * Пользовательская команда clear
     */
    private Command clear;
    /**
     * Пользовательская команда
     */
    private Command exit;
    /**
     * Пользовательская команда info
     */
    private Command info;
    /**
     * Пользовательская команда max_by_to
     */
    private Command max_by_to;
    /**
     * Пользовательская команда print_desceding
     */
    private Command print_desceding;
    /**
     * Пользовательская команда print_field_ascending_distance
     */
    private Command print_field;
    /**
     * Пользовательская команда remove
     */
    private Command remove;
    /**
     * Пользовательская команда remove_greater
     */
    private Command remove_greater;
    /**
     * Пользовательская команда save
     */
    private Command save;
    /**
     * Пользовательская команда update
     */
    private Command update;
    /**
     * Пользовательская команда help
     */
    private Command help;
    /**
     * Пользовательская команда history
     */
    private Command history;
    /**
     * Пользовательская команда execute
     */
    private Command execute;
    /**
     * Массив команд
     */
    private Command[] commands;

    /**
     * Конструктор для задания команд.
     * @param file Файл
     * @param routes Колекция элементов
     * @param help Команда help
     * @param info Команда info
     * @param show Команда show
     * @param add Команда add
     * @param update Команда update
     * @param remove_by_id Команда remove_by_id
     * @param clear Команда clear
     * @param save Команда save
     * @param execute_script Команда execute_script
     * @param exit Команда exit
     * @param add_if_max Команда add_if_max
     * @param remove_greater Команда remove_greater
     * @param history Команда history
     * @param max_by_to Команда max_by_to
     * @param print_descending Команда print_descending
     * @param print_field_ascending_distance Команда print_field_ascending_distance
     */
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
        this.print_field=print_field_ascending_distance;
        this.print_field.setName("print_field_ascending_distance");
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
                this.print_field, this.remove, this.remove_greater, this.save, this.update, this.execute,this.help,this.show,this.history};




    }

    /**
     * Выполнение команды add
     */
    public void add(){
        add.execute();
    };
    /**
     * Выполнение команды show
     */
    public void show(){
        show.execute();
    };
    /**
     * Выполнение команды add_if_max
     */
    public void add_if_max(){
        add_if_max.execute();
    };
    /**
     * Выполнение команды clear
     */
    public void clear(){
        clear.execute();
    };
    /**
     * Выполнение команды exit
     */
    public void exit(){
        exit.execute();
    };
    /**
     * Выполнение команды info
     */
    public void info(){
        info.execute();
    };
    /**
     * Выполнение команды max_by_to
     */
    public void max_by_to(){
        max_by_to.execute();
    };
    /**
     * Выполнение команды print_desceding
     */
    public void print_desceding(){
        print_desceding.execute();
    };
    /**
     * Выполнение команды print_field_ascending_distance
     */
    public void print_field_ascending_distance(){
        print_field.execute();
    }
    /**
     * Выполнение команды remove_by_id
     */
    public void remove_by_id(){
        remove.execute();
    };
    /**
     * Выполнение команды remove_greater
     */
    public void remove_greater(){
        remove_greater.execute();
    };
    /**
     * Выполнение команды save
     */
    public void save(){
        save.execute();
    };
    /**
     * Выполнение команды update
     */
    public void update(){
        update.execute();
    };
    /**
     * Выполнение команды help
     */
    public void help(){
        help.execute();
    };
    /**
     * Выполнение команды
     */
    public void history(){
        history.execute();
    };
    /**
     * Выполнение команды execute_script
     */
    public void execute_script(){
        execute.execute();
    };


    /**
     *
     * @return Массив команд
     */
    public Command[] getCommands() {
        return this.commands;
    }
}
