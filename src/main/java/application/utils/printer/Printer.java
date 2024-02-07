package application.utils.printer;

import static application.utils.constants.ConstantContainer.*;

public class Printer {

    private Printer() { }

    public static void printSuccessfulSaveMethodMessage() {
        System.out.println(" save successful ");
    }

    public static void printSuccessfulDeleteMethodMessage() {
        System.out.println("delete successful");
    }

    public static void printSuccessfulUpdateMethodMessage() {
        System.out.println("update successful");
    }

    public static void printStartMenuMessage() {
        System.out.println(CREATE_ENTITY + DELETE_ENTITY + UPDATE_ENTITY + READ_ENTITY);
    }

    public static void printSelectEntityMessage() {
        System.out.println("1.House\n" + "2.Door\n" + "0.Exit");
    }

    public static void printEnterId() {
        System.out.println("Please, enter id");

    }

    public static void printEnterSize() {
        System.out.println("Please, enter size");
    }

    public static void printEnterType() {
        System.out.println("Please, enter type");
    }

    public static void printEnterColor() {
        System.out.println("Please, enter color");
    }

    public static void printEnterRoomCount() {
        System.out.println("Please, enter count of room");
    }

    public static void printEnterHouseIdForDelete() {
        System.out.println("Please, enter the id of the house you want to delete");
    }

    public static void printEnterHouseIdForRead() {
        System.out.println("Please, enter the id of the house you want to find");
    }

    public static void printHouseUpdateMessage() {
        System.out.println("Enter new data and the ID of the house you want to change");
    }

    public static void printDoorUpdateMessage() {
        System.out.println("Enter new data and the ID of the door you want to change");
    }

    public static void printEnterDoorIdForRead() {
        System.out.println("Please, enter the id of the door you want to find");
    }

    public static void printEnterDoorIdForDelete() {
        System.out.println("Please, enter the id of the door you want to delete");
    }

    public static void printEnterIntegerValueMessage() {
        System.out.println((char) 27 + "[31m" + "enter integer value!" + (char) 27 + "[0m");
    }

    public static void printEnterDoubleValueMessage() {
        System.out.println((char) 27 + "[31m" + "enter double value! format: 0,0" + (char) 27 + "[0m");
    }

    public static void printSwitchDefaultMessage() {
        System.out.println((char) 27 + "[31m" +  "Please, enter value between 0 & 2" + (char) 27 + "[0m");
    }

    public static void printSwitchDefaultMenu() {
        System.out.println((char) 27 + "[31m" +  "Please, enter value between 1 & 4" + (char) 27 + "[0m");
    }

    public static void printSwitchNullMessage() {
        System.out.println((char) 27 + "[34m" +  "Good buy" + (char) 27 + "[0m");
    }

    public static void printNotFoundMessage() {
        System.out.println("404 Not found");
    }

}
