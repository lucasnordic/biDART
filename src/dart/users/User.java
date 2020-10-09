package dart.users;

import java.util.UUID;

/**
 * This class is only a blueprint for sub-classes Employee, Customer etc.
 */

public class User {

    private String id;
    protected String name;
    private String password;

    /**
     *  Constructor:
     */

    public User(String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    /**
     *  Getters and Setters:
     */

    public final String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }

    public void getPassword(String password) {
        this.password= password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}