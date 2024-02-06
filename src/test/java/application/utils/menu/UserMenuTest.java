package application.utils.menu;

import application.utils.menu.UserMenu;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

@Ignore
class UserMenuTest {

    @Test
    void getStartMenuTest(){
        String testInput = "1\n";
        Scanner testScanner = new Scanner(testInput);
        int result = UserMenu.getStartMenu(testScanner);
        Assert.assertEquals(1, result);
    }

    @Test
    void addDoubleValueTest() {
        String testInput = "1,0\n";
        Scanner testScanner = new Scanner(testInput);
        double result = UserMenu.addDoubleValue(testScanner);
        Assert.assertEquals(1.0, result,0.1);
    }

    @Test
    void addIntegerValueTest() {
        String testInput = "10\n";
        Scanner testScanner = new Scanner(testInput);
        int result = UserMenu.addIntegerValue(testScanner);
        Assert.assertEquals(10, result, 0);
    }
}