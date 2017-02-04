package hw5.chat_graphic.domain;

/**
 * Created by eriol4ik on 27/01/2017.
 */
public class Message {
    private Type type;
    private String gsonString;

    public Message(Type type, String gsonString) {
        this.type = type;
        this.gsonString = gsonString;
    }

    public Type getType() {
        return type;
    }

    public String getGsonString() {
        return gsonString;
    }
}
