package hw5.chat_graphic.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public class TextMessage {
    private Integer id;
    private String text;
    private String login;
    private String dateString;
    private transient LocalDateTime date;

    final transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public TextMessage(String login, String text) {
        this.login = login;
        this.text = text;
        this.date = LocalDateTime.now();
        this.dateString = date.format(formatter);
    }

    public String getText() {return text;}
    public String getLogin() {return login;}
    public String getDate() {return dateString;}

    @Override
    public String toString() {
        return login + ", " + text + ", " + dateString;
    }
}
