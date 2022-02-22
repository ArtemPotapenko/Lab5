package Command;

import RouteDir.*;

import java.io.File;
import java.util.*;

public class InfoCommand extends Commands{

    public InfoCommand(LinkedHashSet<Route> routes, File file) {
        super(routes, file);
    }

    private Date DateCreate(){
        return Collections.min(routes, Comparator.comparing(Route::getCreationDate)).getCreationDate();
    }
    private Date DateLastModification(){
        return Collections.max(routes, Comparator.comparing(Route::getCreationDate)).getCreationDate();
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Дата инициализации: "+DateCreate());
        System.out.println("Количество элементов: " + routes.size());
        System.out.println("Тип данных: " + routes.getClass());
        System.out.println("Дата посоеднего изменеия: "+DateLastModification());
    }

    @Override
    public String ru_description() {
        return "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public boolean HaveArgument() {
        return false;
    }
}
