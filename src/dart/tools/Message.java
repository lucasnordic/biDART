package dart.tools;

import java.util.UUID;

public class Message {
    private String messageFrom;
    private String messageTo;   // If message to null then all employees.
    private String message;     // If message == upgrade then user wants an upgrade
    private final String id = UUID.randomUUID().toString();

    public Message(String messageFrom, String messageTo, String message) {
        this.messageFrom = messageFrom;
        this.messageTo = messageTo;
        this.message = message;
    }

    /**
     *  Getters and setters:
     */

    public String getMessageFrom() {
        return messageFrom;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }
}
