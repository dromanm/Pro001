package w5.chat.exceptions;

/**
 * Created by Bohdan on 19.12.2016.
 */
public class ServerPortInputException extends Exception
{
    public ServerPortInputException()
    {
        super("Enter valid server port");
    }
}
