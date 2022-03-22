import routedir.Route;
import run.OpenFile;
import run.ReadCommand;

import java.io.IOException;
import java.util.LinkedHashSet;

/**
 * Главный класс для работы с файлом и взаимодействия с пользователем.
 * @version 1.0
 * @see OpenFile
 * @see ReadCommand
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<Route> a=new LinkedHashSet<>();
        ReadCommand.ReadCommand(OpenFile.fileOpen_csv("args[0]",a),a);
        }}

