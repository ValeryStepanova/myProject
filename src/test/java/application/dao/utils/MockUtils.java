package application.dao.utils;

import application.entity.Door;
import application.entity.House;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static application.dao.utils.MockConstant.*;

public class MockUtils {

public static Door getDoor(){
    return Door.builder()
            .size(DOOR_SIZE)
            .type(DOOR_TYPE)
            .build();
}

    public static Door getDoor2(){
        return Door.builder()
                .size(DOOR_SIZE2)
                .type(DOOR_TYPE2)
                .build();
    }

    public static House getHouse() {
    return House.builder()
            .size(HOUSE_SIZE)
            .color(HOUSE_COLOR)
            .roomCount(COUNT_OF_ROOM)
            .build();
}

    public static House getHouse2() {
        return House.builder()
                .size(HOUSE_SIZE2)
                .color(HOUSE_COLOR2)
                .roomCount(COUNT_OF_ROOM2)
                .build();
    }

    public static void  assertDoor(Door entityDoor, Door door) {
        Assert.assertNotNull(entityDoor);
        Assert.assertEquals("size not equals", entityDoor.getSize(), door.getSize());
        Assert.assertEquals("type not equals", entityDoor.getType(), door.getType());
    }

    public static void assertHouse(House entityHouse, House house) {
        Assert.assertNotNull(entityHouse);
        Assert.assertEquals("size not equals", entityHouse.getSize(), house.getSize());
        Assert.assertEquals("color not equals", entityHouse.getColor(), house.getColor());
        Assert.assertEquals("count of room not equals", entityHouse.getRoomCount(), house.getRoomCount());
    }

    public static ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        return mockOut;
    }

}
