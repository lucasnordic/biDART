package dart.tools;

import java.util.UUID;

public class Message {
    private String messageFromId; //
    private String messageToId;   // If message to null then all employees.
    private String message;     // If message == upgrade then user wants an upgrade
    private final String messageId = UUID.randomUUID().toString();
    private String rentStatus = "available";

    public Message(String message, String messageFromId, String messageToId) {
        this.messageFromId = messageFromId;
        this.messageToId = messageToId;
        this.message = message;
    }

    /**
     *  Getters and setters:
     */

    public String getMessageFrom() {
        return messageFromId;
    }

    public String getMessageTo() {
        return messageToId;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageId() {
        return messageId;
    }
}
