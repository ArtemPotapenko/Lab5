package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Абстрактный класс для команд, которым нужен массив команд
 * @version 1.0
 */
public abstract class CommandsUseArray extends Commands{
    /**
     * Массив команд
     */
    private Command[] commands;



    public CommandsUseArray(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }


    /**
     *
     * @return Массив команд
     */
    public Command[] getCommands() {
        return commands;
    }

    /**
     * Задать массив команд
     * @param commands Массив команд
     */
    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public boolean NeedCommands() {
        return true;
    }
}
