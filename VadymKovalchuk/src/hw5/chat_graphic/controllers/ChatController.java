package hw5.chat_graphic.controllers;


import hw5.chat_graphic.domain.TextMessage;
import hw5.chat_graphic.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by eriol4ik on 21/01/2017.
 */

public class ChatController {
    @FXML private TextField messageField;
    @FXML private TableView<TextMessage> messagesTable;
          private ObservableList<TextMessage> messages;
    @FXML private TableColumn<TextMessage, String> user;
    @FXML private TableColumn<TextMessage, String> text;
    @FXML private TableColumn<TextMessage, String> date;
//    private SignData user;
    private Client client;

    private Thread readMessagesThread;

    public void initialize() {
        messages = FXCollections.observableArrayList();
        messagesTable.setPlaceholder(new Label("Your message history will be displayed here"));

        user.setCellValueFactory(new PropertyValueFactory<>("login"));
        text.setCellValueFactory(new PropertyValueFactory<>("text"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        messagesTable.setItems(messages);

        (readMessagesThread = new Thread(() -> readTextMessages())).start();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @FXML
    public void onActionSendButton() {
        if (!messageField.getText().equals("")) {
            TextField textField = new TextField(messageField.getText());
            textField.setEditable(false);
            textField.setStyle( "-fx-background-color: transparent;" +
                                "-fx-background-insets: 0px;");
            TextMessage textMessage = new TextMessage(client.getLogin(), textField.getText());
            messages.add(textMessage);
            messageField.setText("");
            client.writeTextMessage(textMessage);
        }
    }

    public void readTextMessages() {
        while (client.isConnected()) {
            TextMessage textMessage = client.readTextMessage();
            if (textMessage != null) {
                messages.add(textMessage);
            }
        }
    }

    public void stopReadingMessages() {
        readMessagesThread.interrupt();
    }
}
