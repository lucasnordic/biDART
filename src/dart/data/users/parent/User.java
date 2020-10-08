package dart.data.users.parent;

import java.util.UUID;

public abstract class User {

    private String id;
    protected  String name;
//    protected String password;

    // Constructor:
    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
//        this.password = password;
    }

    public String getId() {
        return id;
    }

    public abstract String getName(String test);

    public void setName(String name) {
        this.name = name;
    }

}