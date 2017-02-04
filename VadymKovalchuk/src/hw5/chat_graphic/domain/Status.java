package hw5.chat_graphic.domain;

/**
 * Created by eriol4ik on 27/01/2017.
 */
public enum Status {
    SUCCESS, SQL_EXCEPTION, INCORRECT_PASSWORD, NO_SUCH_USER, USER_EXISTS, SERVER_ERROR, UNKNOWN;

    @Override
    public String toString() {
        switch(this) {
            case SUCCESS:
                return "";
            case SQL_EXCEPTION:
                return "SQL Exception";
            case INCORRECT_PASSWORD:
                return "Incorrect password";
            case NO_SUCH_USER:
                return "No such user";
            case USER_EXISTS:
                return "User exists";
            case UNKNOWN:
                return "Unknown error";
            case SERVER_ERROR:
                return "Cannot connect to server";
            default:
                return "unknown";
        }
    }
}
