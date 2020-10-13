package dart.tools;

import java.util.UUID;

public class Message {
    private String messageFromId; //
    private String messageToId;   // If message to null then all employees.
    private String message;     // If message == upgrade then user wants an upgrade
    private final String messageId = UUID.randomUUID().toString();
    // private String messageStatus = "unread"; //this is the same with boolean
    private boolean isRead;

    public Message(String message, String messageFromId, String messageToId) {
        this.messageFromId = messageFromId;
        this.messageToId = messageToId;
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead() {
        isRead = true;
    }// this changes status of message


    /**
     * Getters and setters:
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

    @Override
    public String toString() {
        return "New message!\n" +
                "Message ID: " + messageId + "\n" +
                "From : " + messageFromId + "\n" +
                "To : '" + messageToId + "\n" +
                "" + message + "\n" +
                "Status:" + "(" + (isRead ? "read" : "unread ") + ")\"\\n\"";//boolean that change read to unread and back

        //", messageStatus='" + messageStatus + '\'' +;
    }
}
