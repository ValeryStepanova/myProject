package application.utils.menu;

import application.door.Door;
import application.door.doorDAO.DAOImplDoor;
import application.house.House;
import application.house.houseDAO.DAOImplHouse;
import application.utils.printer.Printer;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


public class UserMenu {

    private static double size;
    private static String color;
    private static int id;
    private static int count;
    private static String type;

    private UserMenu() {
    }

    public static void processingUserValue(DAOImplHouse houses, DAOImplDoor doors, Scanner scanner) throws NoSuchFieldException, IllegalAccessException {

        while (true) {
            Printer.printSelectEntityMessage();
            int num = addIntegerValue(scanner);

            switch (num) {
                case 1:
                    switch (getStartMenu(scanner)) {
                        case 1:
                            Printer.printEnterSize();
                            size = addDoubleValue(scanner);
                            Printer.printEnterColor();
                            color = scanner.next();
                            Printer.printEnterRoomCount();
                            count = addIntegerValue(scanner);

                            houses.create(House
                                    .builder()
                                    .size(size)
                                    .color(color)
                                    .roomCount(count)
                                    .build());
                            System.out.println();
                            break;

                        case 2:
                            Printer.printEnterHouseIdForDelete();
                            id = addIntegerValue(scanner);
                            houses.delete(id);
                            break;

                        case 3:
                            Printer.printHouseUpdateMessage();
                            Printer.printEnterId();
                            id = addIntegerValue(scanner);
                            Printer.printEnterSize();
                            size = addDoubleValue(scanner);
                            Printer.printEnterColor();
                            color = scanner.next();
                            Printer.printEnterRoomCount();
                            count = addIntegerValue(scanner);

                            houses.update(House
                                    .builder()
                                    .size(size)
                                    .color(color)
                                    .roomCount(count)
                                    .build(), id);
                            break;

                        case 4:
                            Printer.printEnterHouseIdForRead();
                            id = addIntegerValue(scanner);
                            Optional<House> optional = Optional.ofNullable(houses.read(id));
                            optional.ifPresent(System.out::println);
                            break;
                        default:

                    }
                    break;
                case 2:
                    switch (getStartMenu(scanner)) {
                        case 1:
                            Printer.printEnterSize();
                            size = addDoubleValue(scanner);
                            Printer.printEnterType();
                            type = scanner.next();

                            doors.create(Door.builder()
                                    .size(size)
                                    .type(type)
                                    .build());
                            break;

                        case 2:
                            Printer.printEnterDoorIdForDelete();
                            id = addIntegerValue(scanner);
                            doors.delete(id);
                            break;
                        case 3:
                            Printer.printDoorUpdateMessage();
                            Printer.printEnterId();
                            id = addIntegerValue(scanner);
                            Printer.printEnterSize();
                            size = addDoubleValue(scanner);
                            Printer.printEnterType();
                            type = scanner.next();

                            doors.update(Door.builder()
                                    .size(size)
                                    .type(type)
                                    .build(), id);
                            break;
                        case 4:
                            Printer.printEnterDoorIdForRead();
                            id = addIntegerValue(scanner);
                            Optional<Door> opt = Optional.ofNullable(doors.read(id));
                            opt.ifPresent(System.out::println);
                            break;
                    }
                    break;
                case 0:
                    Printer.printSwitchNullMessage();
                    return;
                default:
                    Printer.printSwitchDefaultMessage();
            }
        }
    }

    public static int getStartMenu(Scanner scanner) {
        Printer.printStartMenuMessage();
        int num = addIntegerValue(scanner);
        if (num > 4 | num < 0) {
            getStartMenu(scanner);
        }
        return num;
    }


    public static double addDoubleValue(Scanner scanner) {
        double number = -1.0;
        while (number < 0)
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                Printer.printEnterDoubleValueMessage();
                scanner.next();
            }
        return number;
    }

    public static int addIntegerValue(Scanner scanner){
        int number = -1;
        while (number < 0)
        try {
        number = scanner.nextInt();
    } catch (InputMismatchException e) {
        Printer.printEnterIntegerValueMessage();
        scanner.next();
    }
        return number;
    }
}
