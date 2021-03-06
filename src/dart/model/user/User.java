package dart.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class is only a blueprint for sub-classes Employee, Customer etc.
 */

public abstract class User implements Serializable {

    protected String id = UUID.randomUUID().toString();
    private String name;
    private String password;
    private final String type = "User";
//    private ArrayList<Message> messageList = new ArrayList<>();

  
    /**
     *  Constructor:
     */
  
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User (){

    }

    // For constructing a User from a file:
    public User(String[] savedAttributes) {
        this.id = savedAttributes[1];
        this.name = savedAttributes[2];
        this.password= savedAttributes[3];
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