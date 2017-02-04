package hw5.chat_graphic.controllers;

import hw5.chat_graphic.domain.Result;
import hw5.chat_graphic.domain.Status;
import hw5.chat_graphic.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by eriol4ik on 26/01/2017.
 */
public class LoginController {

    @FXML private TextField loginField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorMsg;

    @FXML private Button signIn;
    @FXML private Button signUp;

    @FXML private TextField ipField;

    private Client client;

    public void initialize() {
        client = new Client();
    }

    @FXML
    public void authOrReg(ActionEvent event) throws IOException {

        setErrorMsg(client.openConnection(ipField.getText()));

        if (!client.isConnected()) {return;}
        if (!loginField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            String login = loginField.getText();
            String password = passwordField.getText();
            if (event.getSource() == signIn || event.getSource() == passwordField) {
                client.authorize(login, password);
            } else {
                client.register(login, password);
            }
            Result result = client.readResult();

            switch (result.getStatus()) {
                case SUCCESS:
                    Integer sessionId = result.getSessionId();
                    showChatWindowFor(login, sessionId);
                    break;
                case SQL_EXCEPTION:
                    setErrorMsg(Status.SQL_EXCEPTION);
                    break;
                case INCORRECT_PASSWORD:
                    setErrorMsg(Status.INCORRECT_PASSWORD);
                    break;
                case NO_SUCH_USER:
                    setErrorMsg(Status.NO_SUCH_USER);
                    break;
                case USER_EXISTS:
                    setErrorMsg(Status.USER_EXISTS);
                    break;
                case UNKNOWN:
                    setErrorMsg(Status.UNKNOWN);
                    break;
            }
        } else {

        }
    }

    private void showChatWindowFor(String login, Integer sessionId) throws IOException {
        Stage loginStage = (Stage) loginField.getScene().getWindow();
        loginStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/chat.fxml"));
        GridPane pane = loader.load();

        ChatController chatController = loader.getController();

        client.setLogin(login);
        client.setSessionId(sessionId);

        chatController.setClient(client);

        Stage stage = new Stage();
        stage.setTitle("Chat");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setOnCloseRequest((event) -> {
            chatController.stopReadingMessages();
            client.closeConnection();
        });
        stage.show();
    }

    private void setErrorMsg(Status status) {
        errorMsg.setText(status.toString());
    }

}
