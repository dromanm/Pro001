package w4.net.message;

import java.io.Serializable;

/**
 * Created by Bohdan on 15.01.2017.
 */
public class Message implements Serializable
{
    private MessageType messageType;

    private String textData;

    public MessageType getMessageType()
    {
        return messageType;
    }

    public String getTextData()
    {
        return textData;
    }

    public Message(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public Message(MessageType messageType, String textData)
    {
        this.messageType = messageType;
        this.textData = textData;
    }
}
