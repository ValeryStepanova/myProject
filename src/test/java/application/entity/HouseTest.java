package application.entity;

import application.entity.House;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.utils.MockUtils.getHouse;

class HouseTest {

    @Test
    void setIdTest() {
        House house = getHouse();
        house.setId(1);
        Assert.assertEquals(1, house.getId(), 0);
    }

    @Test
    void setSize() {
        House house = getHouse();
        house.setSize(4.0);
        Assert.assertEquals(4.0, house.getSize(), 0);
    }

    @Test
    void setColor() {
        House house = getHouse();
        house.setColor("green");
        Assert.assertEquals("color not equals", house.getColor(), "green");
    }

    @Test
    void setRoomCount() {
        House house = getHouse();
        house.setRoomCount(3);
        Assert.assertEquals(3, house.getRoomCount(), 0);
    }

    @Test
    void testToString() {
        House house = getHouse();
        Assert.assertEquals("to string not equals", house.toString(), "House(id=0, size=8.58, color=Red, roomCount=1)");
    }

    @Test
    void getId() {
        House house = getHouse();;
        house.setId(1);
        Assert.assertEquals(house.getId(), 1, 0);
    }

    @Test
    void getSize() {
        House house = getHouse();
        house.setSize(4.0);
        Assert.assertEquals(house.getSize( ), 4.0, 0);
    }

    @Test
    void getColor() {
        House house = getHouse();
        house.setColor("gray");
        Assert.assertEquals("color not equals", house.getColor(), "gray");
    }

    @Test
    void getRoomCount() {
        House house = getHouse();
        house.setRoomCount(8);
        Assert.assertEquals(8, house.getRoomCount(), 0);
    }

    @Test
    void builder() {
        House house1 = House.builder()
                .size(1.0)
                .color("red")
                .roomCount(4)
                .build();

        House house2 = house1;
        Assert.assertEquals("build not equals", house1, house2);
    }
}