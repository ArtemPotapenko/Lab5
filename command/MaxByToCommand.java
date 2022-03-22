package command;

import routedir.Route;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Вывод максимального элемента по полю локации въезда
 * Элементы сравниваются по хэшкоду
 * @version 1.0
 */
public class MaxByToCommand extends Commands{
    public MaxByToCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    @Override
    public void execute() {
        if (routes.size()!=0){
        System.out.println(Collections.max(routes,(x,y)->x.getTo().compareTo(y.getTo())));}
        else {
            System.out.println("Список не содержит элементов");
        }

    }

    @Override
    public String ru_description() {
        return "вывести любой объект из коллекции, значение поля to которого является максимальным";
    }
}
