package command;

import routedir.Route;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Вывод коллекции
 * @version 1.0
 */
public class ShowCommand extends Commands{
    public ShowCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        routes.forEach(x->x.ShowPrint());
        if (routes.size()==0){
            System.out.println("В списке нет элементов");
        }

    }

    @Override
    public String ru_description() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
