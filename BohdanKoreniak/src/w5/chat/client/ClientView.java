package w5.chat.client;

import w5.chat.User;
import w5.chat.View;
import w5.chat.exceptions.ServerAddressInputException;
import w5.chat.exceptions.ServerPortInputException;
import w5.chat.message.Message;
import w5.chat.message.MessageType;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

import java.util.Optional;

import static w5.chat.constants.GuiElementSize.*;

/**
 * Created by Bohdan on 27.01.2017.
 */
public class ClientView implements View
{
    private ClientController controller;

    private GridPane gridPane = new GridPane();

    private TextArea textAreaMessages = new TextArea();
    private TextField textFieldMessageToSend = new TextField();
    private ListView<User> listViewUsers = new ListView<>();

    private Button buttonSendMessage = new Button();

    public ClientView(ClientController controller)
    {
        this.controller = controller;
        init();
    }

    @Override
    public void init()
    {
        textAreaMessages.setMinSize(MEDIUM_ELEMENT_WIDTH, MEDIUM_ELEMENT_HEIGHT);
        textAreaMessages.setEditable(false);

        textFieldMessageToSend.setMinSize(MEDIUM_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);

        buttonSendMessage.setMinSize(MEDIUM_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        buttonSendMessage.setText("Send message");
        buttonSendMessage.setOnAction(event ->
        {
            controller.sendMessage(new Message(MessageType.TEXT, textFieldMessageToSend.getText()));
            textFieldMessageToSend.clear();
        });

        textFieldMessageToSend.setOnKeyPressed(event ->
        {
            if (event.getCode() == KeyCode.ENTER)
            {
                buttonSendMessage.fire();
            }
        });

        listViewUsers.setItems(controller.getObservableListUsers());
        listViewUsers.setMinSize(SMALL_ELEMENT_WIDTH, MEDIUM_ELEMENT_HEIGHT);
        listViewUsers.setMaxHeight(MEDIUM_ELEMENT_HEIGHT + INSETS_SIZE * 2 + SMALL_ELEMENT_HEIGHT * 2);

        gridPane.add(textAreaMessages, 0, 0);
        gridPane.add(textFieldMessageToSend, 0, 1);
        gridPane.add(buttonSendMessage, 0, 2);
        gridPane.add(listViewUsers, 1, 0, 1, 3);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setHgap(INSETS_SIZE);
        gridPane.setVgap(INSETS_SIZE);
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    public String getServerAddress() throws ServerAddressInputException
    {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Client configuration");
        textInputDialog.setContentText("Enter server address");

        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent())
        {
            return result.get();
        }

        throw new ServerAddressInputException();
    }

    public int getServerPort() throws ServerPortInputException
    {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Client configuration");
        textInputDialog.setContentText("Enter server port");

        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent())
        {
            try
            {
                return Integer.parseInt(result.get());
            }
            catch (Exception e)
            {
                throw new ServerPortInputException();
            }
        }

        throw new ServerPortInputException();
    }

    public User getUser()
    {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Client configuration");
        textInputDialog.setContentText("Enter user name");

        Optional<String> result = textInputDialog.showAndWait();

        return new User(result.get());
    }

    public void addTextToTextArea(String text)
    {
        textAreaMessages.appendText(text + "\n");
    }
}
