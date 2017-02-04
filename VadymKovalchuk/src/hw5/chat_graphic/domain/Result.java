package hw5.chat_graphic.domain;

/**
 * Created by eriol4ik on 27/01/2017.
 */
public class Result {
    Status status;
    Integer sessionId;

    public Result(Status status, Integer sessionId) {
        this.status = status;
        this.sessionId = sessionId;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getSessionId() {
        return sessionId;
    }
}
