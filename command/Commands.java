package command;


import java.io.File;
import java.util.LinkedHashSet;
/**
 * Адстрактный класс для команд
 * @version 1.0
 */
import routedir.*;
public abstract class Commands implements Command{
    /**
     * Массив элементов
     */
    protected LinkedHashSet<Route> routes;
    /**
     * Файл для записи
     */
    File file;

    /**
     * Конструктор для задания команды.
     * @param routes Коллекция элементов
     * @param file Файл
     */
    public Commands( LinkedHashSet<Route> routes, File file){
        this.routes=routes;
        this.file=file;
    }

    /**
     * Имя команды
     */
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
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
