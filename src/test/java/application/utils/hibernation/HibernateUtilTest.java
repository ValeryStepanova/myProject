package application.utils.hibernation;

import application.utils.hibernation.HibernateUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class HibernateUtilTest {

    @Test
    void getEntityManager() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Assert.assertTrue(entityManager.isOpen());
        entityManager.close();
    }

    @Test
    void close() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        HibernateUtil.close();
        Assert.assertFalse(entityManager.isOpen());
    }
}