package w5.chat.client;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import w5.chat.Controller;
import w5.chat.User;
import w5.chat.exceptions.ServerAddressInputException;
import w5.chat.exceptions.ServerPortInputException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 27.01.2017.
 */
public class ClientController extends Client implements Controller
{
    private String serverAddress;
    private int serverPort;

    private User user;

    private ObservableList<User> observableListUsers = new ObservableListWrapper<User>(new ArrayList<>());

    private ClientView view = new ClientView(this);

    @Override
    public ClientView getView()
    {
        return view;
    }

    public class SocketThread extends Client.SocketThread
    {
        @Override
        protected void processIncomingTextMessage(String text)
        {
            Platform.runLater(() -> view.addTextToTextArea(text));
        }

        @Override
        protected void informAboutAddingNewUser(User user)
        {
            Platform.runLater(() -> view.addTextToTextArea(user.getLogin() + " connected to the chat"));
        }

        @Override
        protected void informAboutDeletingUser(User user)
        {
            Platform.runLater(() -> view.addTextToTextArea(user.getLogin() + " disconnected from the chat"));
        }

        @Override
        protected void processIncomingUserList(List<User> users)
        {
            Platform.runLater(() ->
            {
                observableListUsers.clear();
                observableListUsers.addAll(users);
            });
        }
    }

    public ObservableList<User> getObservableListUsers()
    {
        return observableListUsers;
    }

    @Override
    protected String getServerAddress()
    {
        return serverAddress;
    }

    @Override
    protected int getServerPort()
    {
        return serverPort;
    }

    @Override
    protected User getUser()
    {
        return user;
    }

    @Override
    protected Client.SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    @Override
    public void run()
    {
        try
        {
            serverAddress = view.getServerAddress();
            serverPort = view.getServerPort();
            user = view.getUser();

            Client.SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            try
            {
                synchronized (this)
                {
                    this.wait();
                }
            }
            catch (InterruptedException e)
            {
                return;
            }

            if (clientConnected)
            {
                Platform.runLater(() -> ClientMain.getInstance().replaceSceneContent(this));
            }
        }
        catch (ServerAddressInputException | ServerPortInputException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }
}
