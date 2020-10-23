package dart.model.users;

import java.util.UUID;

public class Message {
    private String messageFromId; // we want to store the id from the sender.
    private String name;          // Same with name.
    private String messageToId;   // If message to null then message goes to all employees.
    private String message;       // If message == upgrade then user wants an upgrade
    private final String messageId = UUID.randomUUID().toString();
    private boolean isRead;
    private String type;          // personal, employee. if customer then  we check messageTo ID.
                                  // If employee then we only check type.
                                  // the message is for all employees.

    public Message(String message, String name, String messageFromId, String messageToId, String type) {
        this.messageFromId = messageFromId;
        this.name = name;
        this.messageToId = messageToId;
        this.message = message;
        this.type = type;
    }

    public boolean getIsRead() {
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

    public String getType() {
        return type;
    }

    public boolean isOfType(String type) {
        return this.type.equals(type);
    }

    @Override
    public String toString() {
        return "Message Inbox :)\n" +
                "Status : " + "(" + (isRead ? "read" : " unread ") + ")\n" +//boolean that change read to unread and back
                "From   : " + name + " : " + messageFromId + "\n" +
                "Text   : " + message + "\n";


        //", messageStatus='" + messageStatus + '\'' +;
    }
}
