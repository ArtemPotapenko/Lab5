package Command;

import java.io.FileNotFoundException;

public interface Command  {
    /**
     command execute
     */
    void execute() ;

    /**
     *
     * @return description command in Russian
     */
    String ru_description();

    /**
     *
     * @return true if Command has Argument
     */
    boolean HaveArgument();

    /**
     *
     * @return Command name
     */
    String getName();

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @return true if use Command[] from users
     */
    boolean NeedCommands();
}
