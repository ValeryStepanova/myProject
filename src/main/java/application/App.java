package application;

import application.dao.daoClasses.DAOImplDoor;
import application.dao.daoClasses.DAOImplHouse;
import application.utils.hibernation.HibernateUtil;
import application.utils.menu.UserMenu;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        DAOImplHouse house = new DAOImplHouse(entityManager);
        DAOImplDoor door = new DAOImplDoor(entityManager);
        Scanner scanner = new Scanner(System.in);
        UserMenu.processingUserValue(house, door, scanner);
        HibernateUtil.close();
    }
}
