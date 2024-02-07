package application.dao.daoClasses;

import application.dao.daoClasses.DAOImplDoor;
import application.dao.daoClasses.DAOImplHouse;
import application.dao.utils.MockUtils;
import application.entity.Door;
import application.entity.House;
import application.utils.hibernation.HibernateUtil;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DAOImplTest {

    House house = MockUtils.getHouse();
    Door door = MockUtils.getDoor();
    EntityManager entityManager = HibernateUtil.getEntityManager();
    DAOImplDoor daoImplDoor = new DAOImplDoor(entityManager);
    DAOImplHouse daoImplHouse = new DAOImplHouse(entityManager);

    @Test
    @Order(1)
    void create() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> queryDoor = builder.createQuery(Long.class);
        queryDoor.select(builder.count(queryDoor.from(Door.class)));

        CriteriaQuery<Long> queryHouse = builder.createQuery(Long.class);
        queryHouse.select(builder.count(queryHouse.from(House.class)));

        Long countDoorBefore = entityManager.createQuery(queryDoor).getSingleResult();
        Long countHouseBefore = entityManager.createQuery(queryHouse).getSingleResult();

        daoImplDoor.create(door);
        daoImplHouse.create(house);

        Long countDoorAfter = entityManager.createQuery(queryDoor).getSingleResult();
        Long countHouseAfter = entityManager.createQuery(queryHouse).getSingleResult();

        Assert.assertNotNull(countDoorAfter);
        Assert.assertNotNull(countHouseAfter);
        Assert.assertEquals(java.util.Optional.of(countDoorBefore + 1), java.util.Optional.ofNullable(countDoorAfter));
        Assert.assertEquals(java.util.Optional.of(countHouseBefore + 1), java.util.Optional.ofNullable(countHouseAfter));

        Door entityDoor = daoImplDoor.read(1);
        House entityHouse = daoImplHouse.read(1);

        MockUtils.assertDoor(entityDoor, door);
        MockUtils.assertHouse(entityHouse, house);
    }

    @Test
    @Order(2)
    void read() {
        Door entityDoor = daoImplDoor.read(1);
        House entityHouse = daoImplHouse.read(1);

        MockUtils.assertDoor(entityDoor, door);
        MockUtils.assertHouse(entityHouse, house);

        Assert.assertTrue(entityManager.isOpen());
        Assert.assertFalse(entityManager.getTransaction().isActive());
        entityManager.close();
    }

    @Test
    @Order(3)
    void update() throws NoSuchFieldException, IllegalAccessException {
        House house2 = MockUtils.getHouse2();
        Door door2 = MockUtils.getDoor2();

        daoImplHouse.update(house2, 1);
        daoImplDoor.update(door2, 1);

        Door entityDoor = daoImplDoor.read(1);
        House entityHouse = daoImplHouse.read(1);

        MockUtils.assertDoor(entityDoor, door2);
        MockUtils.assertHouse(entityHouse, house2);
    }

    @Test
    @Order(4)
    void delete() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> queryDoor = builder.createQuery(Long.class);
        queryDoor.select(builder.count(queryDoor.from(Door.class)));

        CriteriaQuery<Long> queryHouse = builder.createQuery(Long.class);
        queryHouse.select(builder.count(queryHouse.from(House.class)));

        Long countDoorBefore = entityManager.createQuery(queryDoor).getSingleResult();
        Long countHouseBefore = entityManager.createQuery(queryHouse).getSingleResult();

        daoImplHouse.delete(1);
        daoImplDoor.delete(1);

        Long countDoorAfter = entityManager.createQuery(queryDoor).getSingleResult();
        Long countHouseAfter = entityManager.createQuery(queryHouse).getSingleResult();

        Assert.assertNotNull(countDoorBefore);
        Assert.assertNotNull(countHouseBefore);
        Assert.assertEquals(java.util.Optional.of(countDoorBefore - 1), java.util.Optional.ofNullable(countDoorAfter));
        Assert.assertEquals(java.util.Optional.of(countHouseBefore - 1), java.util.Optional.ofNullable(countHouseAfter));
        Assert.assertTrue(entityManager.isOpen());
        Assert.assertFalse(entityManager.getTransaction().isActive());
        entityManager.close();
    }

}