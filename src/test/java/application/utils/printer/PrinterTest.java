package application.utils.printer;

import application.utils.printer.Printer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static application.dao.utils.MockUtils.getByteArrayOutputStream;
import static application.utils.constants.ConstantContainer.*;
import static application.utils.constants.ConstantContainer.READ_ENTITY;

class PrinterTest {


    @Test
    void printSuccessfulSaveMethodMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSuccessfulSaveMethodMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains(" save successful "));
    }

    @Test
    void printSuccessfulDeleteMethodMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSuccessfulDeleteMethodMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("delete successful"));
    }

    @Test
    void printSuccessfulUpdateMethodMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSuccessfulUpdateMethodMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("update successful"));
    }

    @Test
    void printStartMenuMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printStartMenuMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains(CREATE_ENTITY + DELETE_ENTITY + UPDATE_ENTITY + READ_ENTITY));
    }


    @Test
    void printSelectEntityMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSelectEntityMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("1.House\n" + "2.Door\n" + "0.Exit"));
    }

    @Test
    void printEnterIdTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterId();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Please, enter id"));
    }

    @Test
    void printEnterSizeTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterSize();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Please, enter size"));
    }

    @Test
    void printEnterTypeTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterType();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Please, enter type"));
    }

    @Test
    void printEnterColorTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterColor();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Please, enter color"));
    }

    @Test
    void printEnterRoomCountTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterRoomCount();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Please, enter count of room"));
    }

    @Test
    void printEnterHouseIdForDeleteTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterHouseIdForDelete();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Please, enter the id of the house you want to delete"));
    }

    @Test
    void printEnterHouseIdForReadTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterHouseIdForRead();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Please, enter the id of the house you want to find"));
    }

    @Test
    void printHouseUpdateMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printHouseUpdateMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Enter new data and the ID of the house you want to change"));
    }

    @Test
    void printDoorUpdateMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printDoorUpdateMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Enter new data and the ID of the door you want to change"));
    }

    @Test
    void printEnterDoorIdForReadTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterDoorIdForRead();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Please, enter the id of the door you want to find"));
    }

    @Test
    void printEnterDoorIdForDeleteTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterDoorIdForDelete();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Please, enter the id of the door you want to delete"));
    }

    @Test
    void printEnterIntegerValueMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterIntegerValueMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("enter integer value!"));
    }

    @Test
    void printEnterDoubleValueMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printEnterDoubleValueMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("enter double value! format: 0,0"));
    }

    @Test
    void printSwitchDefaultMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSwitchDefaultMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(),
                StandardCharsets.UTF_8).contains("Please, enter value between 0 & 2"));
    }

    @Test
    void printSwitchNullMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printSwitchNullMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("Good buy"));
    }

    @Test
    void printNotFoundMessageTest() {
        ByteArrayOutputStream mockOut = getByteArrayOutputStream();
        Printer.printNotFoundMessage();
        Assert.assertTrue(new String(mockOut.toByteArray(), StandardCharsets.UTF_8).contains("404 Not found"));
    }
}