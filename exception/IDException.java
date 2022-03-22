package exception;

/**
 * Обшибки связанные с некоторректным выбором id
 * @see command.RemoveCommand
 * @see command.UpdateCommand
 * @version 1.0
 */
public class IDException extends RuntimeException{
    public IDException(String message){
        super(message);
    }

}
