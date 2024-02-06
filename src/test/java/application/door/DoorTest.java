package application.door;

import application.door.Door;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.utils.MockUtils.getDoor;

class DoorTest {

    @Test
    void setId() {
        Door door = getDoor();
        door.setId(4);
        Assert.assertEquals(4, door.getId(), 0);
    }

    @Test
    void setSize() {
        Door door = getDoor();
        door.setSize(12.4);
        Assert.assertEquals(12.4, door.getSize(), 0);
    }

    @Test
    void setType() {
        Door door = getDoor();
        door.setType("new Door");
        Assert.assertEquals("setType not equals", door.getType(), "new Door");
    }

    @Test
    void builder() {
        Door door = Door.builder()
                .size(11.1)
                .type("new door")
                .build();

        Door door2 = door;
        Assert.assertEquals("build not equals", door, door2);
    }

    @Test
    void getId() {
        Door door = getDoor();
        door.setId(2);
        Assert.assertEquals(door.getId(), 2, 0);
    }

    @Test
    void getSize() {
        Door door = getDoor();
        door.setSize(12.4);
        Assert.assertEquals(door.getSize(), 12.4, 0);
    }

    @Test
    void getType() {
        Door door = getDoor();
        door.setType("new Door");
        Assert.assertEquals("setType not equals", door.getType(), "new Door");
    }

    @Test
    void testToString() {
        Door door = getDoor();
        Assert.assertEquals("to string not equals", door.toString(), "Door(id=0, size=4.1, type=Door)");
    }
}