package dart.users;

import dart.tools.Message;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is only a blueprint for sub-classes Employee, Customer etc.
 */

public abstract class User {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String password;
    private final String type = "User";
    private ArrayList<Message> messageList = new ArrayList<>();

  
    /**
     *  Constructor:
     */
  
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User (){

    }


    /**
     *  Getters and Setters:
     */

    public final String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    /**
     *  Abstract:
     */

    public abstract String getType();
}