package dart.controller;

import dart.model.user.Customer;
import dart.model.user.Employee;
import dart.model.user.User;
import dart.model.user.Message;
import dart.tool.UserInputHandler;

import java.util.ArrayList;

public class MessageController {
    private ArrayList<Message> messageList = new ArrayList<>();

    public ArrayList<Message> getMessageListForUser(User user) {
        ArrayList<Message> userMessages = new ArrayList<>();

        for (Message message : messageList) {
            if (message.isOfType("employee") && user instanceof Employee) {
                userMessages.add(message);
            } else if (message.isOfType("personal") && user instanceof Customer) {
                if (message.getMessageTo().equals(user.getId())) {
                    userMessages.add(message);
                }
            }
        }

        return userMessages;
    }

    public Message addMessageToList(String message, String name, String messageFromId, String messageToUserId, String type) {
        Message newMessage = new Message(message, name, messageFromId, messageToUserId, type);
        messageList.add(newMessage);

        System.out.println("Message sent! ");

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

    // Removes a message from the message list based on the message id.
    public void removeMessageFromList(String messageId) {
//        Message messageFound = null;
        int index = 0;

        while(index < messageList.size()) {
            Message message = messageList.get(index);

            if (message.getMessageId().equals(messageId)) {
//                messageFound = message
                messageList.remove(index);
                System.out.print("Message was removed! ");
                UserInputHandler.pressAnyKeyCon();
            } else {
                index++;
            }
        }
    }

    // Removes a message from the message list based on a customers id.
    public void removeMessageFromListBasedOnCustomerId(String customerId) {
//        Message messageFound = null;
        int index = 0;

        while(index < messageList.size()) {
            Message message = messageList.get(index);

            if (message.getMessageFrom().equals(customerId)) {
//                messageFound = message
                messageList.remove(index);
                System.out.print("Message was removed! ");
                UserInputHandler.pressAnyKeyCon();
            } else {
                index++;
            }
        }
    }
}