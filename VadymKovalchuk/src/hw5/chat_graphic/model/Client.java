package hw5.chat_graphic.model;

import hw5.chat_graphic.domain.*;
import hw5.chat_graphic.util.LanHelper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import com.google.gson.Gson;

/**
 * Created by eriol4ik on 15/01/2017.
 */

public class Client {
    SocketChannel channel;

    Integer sessionId;
    String login;

    public String getLogin() {
        return login;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    Gson gson = new Gson();

    public boolean isConnected() {
        if (channel == null) return false;

        return channel.isConnected();
    }

    public Client() {}

    public Status openConnection(String ip) {
        int port = 30000;
        try {
            channel = SocketChannel.open(new InetSocketAddress(ip, port));
        } catch (IOException ioe) {
            return Status.SERVER_ERROR;
        }

        return Status.SUCCESS;
    }

    public Status openConnection() {
        return openConnection("localhost");
    }

    public Message readMessage() {
        String gsonMessage = LanHelper.readMessage(channel);
        return gson.fromJson(gsonMessage, Message.class);
    }

    public void writeTextMessage(TextMessage textMessage) {
        String gsonString = gson.toJson(textMessage);
        LanHelper.writeMessage(gsonString, channel, Type.TEXT_MESSAGE);
    }

    public void authorize(String login, String password) {
        SignData signData = new SignData(login, password);
        LanHelper.writeMessage(gson.toJson(signData), channel, Type.AUTHORIZE);
    }

    public void register(String login, String password) {
        SignData signData = new SignData(login, password);
        LanHelper.writeMessage(gson.toJson(signData), channel, Type.REGISTER);
    }

    public Result readResult() {
        Message message = readMessage();
        if (message.getType() == Type.RESULT) {
            return gson.fromJson(message.getGsonString(), Result.class);
        }
        return null;
    }

    public TextMessage readTextMessage() {
        Message message = readMessage();
        if (message != null && message.getType() == Type.TEXT_MESSAGE) {
            return gson.fromJson(message.getGsonString(), TextMessage.class);
        }
        return null;
    }

    public void closeConnection() {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
