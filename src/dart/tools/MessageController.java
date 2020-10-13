package dart.tools;

import dart.users.Customer;
import dart.users.Employee;
import dart.users.User;

import java.util.ArrayList;

public class MessageController {
    private ArrayList<Message> messageList = new ArrayList<>();

    public ArrayList<Message> getMessageListForUser(User user) {
        ArrayList<Message> userMessages = new ArrayList<>();
        for (int i = 0; i < messageList.size(); i++) {
            Message message = messageList.get(i);

            if (user instanceof Employee && message.getMessageTo() == null) {
                userMessages.add(message);
            } else if( user instanceof Customer && message.getMessageTo().equals(user.getId())){
                userMessages.add(message);
            }
        }
        return userMessages;
    }

    public Message addMessageToList(String message, String name, String messageFromId, String messageToUserId) {
        Message newMessage = new Message(message, name, messageFromId, messageToUserId);
        messageList.add(newMessage);

        System.out.print(
                "Message sent!\n" +
                "Press any key to go back... "
        );
        UserInputHandler.pressAnyKeyCon();

        return newMessage;
    }

    public void removeMessage(int choice){
        messageList.remove(choice);
        System.out.println("The message you wanted to remove has been deleted.");
//        for (Message message: messageList) {
//            if (message.getMessageId().equals(choice)){
//                messageList.remove(message);
//                System.out.println("The message you wanted to remove has been deleted.");
//                return;
//            }
//        }
    }

    public Message removeMessageFromList(String messageId) {
        Message messageFound = null;
        int index = 0;

        while(messageFound == null && index < messageList.size()) {
            Message message = messageList.get(index);

            if (message.getMessageId().equals(messageId)) {
//                messageFound = message
                messageList.remove(index);
                System.out.print("Message was removed! Press any key to go back: ");
                UserInputHandler.pressAnyKeyCon();
            } else {
                index++;
            }
        }
        return messageFound;
    }


}
