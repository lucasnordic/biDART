package dart.tools;

import dart.users.Employee;
import dart.users.User;

import java.util.ArrayList;

public class MessageController {
    ArrayList<Message> messageList = new ArrayList<>();

    public ArrayList<Message> getMessageListForUser(User user) {
        ArrayList<Message> userMessages = new ArrayList<>();

        for (int i = 0; i < messageList.size(); i++) {
            Message message = messageList.get(i);

            if (message.getMessageTo().equals(user.getId())) {
                userMessages.add(message);
            } else if(user instanceof Employee && message.getMessageTo() == null){
                userMessages.add(message);
            }
        }

        return userMessages;
    }

    public Message addMessageToList(String message, String messageFromId, String messageToUserId) {
        Message newMessage = new Message(message, messageFromId, messageToUserId);
        messageList.add(newMessage);

        System.out.print(
                "Message sent!\n" +
                "Press any key to go back to your Customer Screen: "
        );
        UserInputHandler.pressAnyKeyCon();

        return newMessage;
    }

    public Message removeMessageFromList(String messageId) {
        Message messageFound = null;
        int index = 0;

        while(messageFound == null && index < messageList.size()) {
            Message message = messageList.get(index);

            if (message.getId().equals(messageId)) {
                messageFound = message;
            } else {
                index++;
            }
        }
        return messageFound;
    }


}