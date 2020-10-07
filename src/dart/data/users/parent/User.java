package dart.data.users.parent;

import java.util.UUID;

public class User {

    private String id;
    protected  String name;
    protected String password;

    // Constructor:
    public User(String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}