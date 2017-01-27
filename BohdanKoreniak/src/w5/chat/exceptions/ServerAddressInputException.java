package w5.chat.exceptions;

/**
 * Created by Bohdan on 19.12.2016.
 */
public class ServerAddressInputException extends Exception
{
    public ServerAddressInputException()
    {
        super("Enter valid server address");
    }
}
