package w5.chat.message;

import java.io.Serializable;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Message<T> implements Serializable
{
    private MessageType messageType;

    private T data;

    public MessageType getMessageType()
    {
        return messageType;
    }

    public T getData()
    {
        return data;
    }

    public Message(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public Message(MessageType messageType, T data)
    {
        this.messageType = messageType;
        this.data = data;
    }
}
