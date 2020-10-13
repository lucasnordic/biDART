package dart.tools;

import java.util.UUID;

public class Message {
    private String messageFromId; // we want to store the id from the sender.
    private String name;          // Same with name.
    private String messageToId;   // If message to null thenmessage goes to all employees.
    private String message;       // If message == upgrade then user wants an upgrade
    private final String messageId = UUID.randomUUID().toString();
    private boolean isRead;

    public Message(String message, String name, String messageFromId, String messageToId) {
        this.messageFromId = messageFromId;
        this.name = name;
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
                "From : " + name + " : " + messageFromId + "\n" +
                "" + message + "\n";
//                "Status:" + "(" + (isRead ? "read" : "unread ") + ")";//boolean that change read to unread and back

        //", messageStatus='" + messageStatus + '\'' +;
    }
}
