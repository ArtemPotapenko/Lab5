package run;

import command.*;
import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс содержит 1 метод для чтения команд
 * @version 1.0
 */
public class ReadCommand {
    /**
     * В методе считывается команда и через <b>ReadFunction</b> оапределяется и выполняется команда для работа с файлом и коллекцией.
     * Выполняет роль приемника команд
     * @param file файл
     * @param a Коллекция
     * @see ReadFunction
     *
     */
    public static void ReadCommand(File file, LinkedHashSet<Route> a) {
        Scanner in = new Scanner(System.in);
        ReadFunction read = new ReadFunction();
        User user = new User(file, a, new HelpCommand(a, file), new InfoCommand(a, file), new ShowCommand(a, file), new AddCommand(a, file)
                , new UpdateCommand(a, file), new RemoveCommand(a, file), new ClearCommand(a, file), new SaveCommand(a, file),
                read.new ExecuteCommand(a, file), new ExitCommand(a, file), new AddIfMaxCommand(a, file), new RemoveCommand(a, file),
                read.new HistoryCommand(a, file), new MaxByToCommand(a, file), new PrintDescendingCommand(a, file), new PrintFieldAscendingDistance(a, file));
        read.setCommands(user.getCommands());
        while (true) {

            System.out.println();
            System.out.print(">");

            try {
                String s = in.nextLine();
                read.read(s);
            } catch (NoSuchElementException e) {
                System.console().readLine();
                System.out.println("Ошибка ввода");
            }
        }
    }
}
