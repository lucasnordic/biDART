package dart.data.items.parent.grandparent;

import java.util.UUID;

public class Item {

    private String id;
    protected  String name;

    // Constructor:
    public Item(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
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
}