package dart.users;

import java.util.UUID;

/**
 * This class is only a blueprint for sub-classes Employee, Customer etc.
 */

public abstract class User {

    private final String id = UUID.randomUUID().toString();
    private String name;
    private String password;

    public User(String name, String password) {
    }

    public User() {

    }

    /**
     *  Constructor:
     */



    /**
     *  Getters and Setters:
     */

    public void setPassword(String password) {
        this.password = password;
    }

    public final String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}