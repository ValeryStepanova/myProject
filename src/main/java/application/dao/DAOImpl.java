package application.dao;

import application.utils.printer.Printer;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class DAOImpl<T> implements DAO<T> {

    private final EntityManager entityManager;

    public DAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(T object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        Printer.printSuccessfulSaveMethodMessage();
    }

    public T read(int id, Class<T> tClass) {
        entityManager.getTransaction().begin();
        T object = entityManager.find(tClass, id);
        if (checkFindById(object)) {
            entityManager.getTransaction().commit();
            return null;
        }
        entityManager.getTransaction().commit();
        return object;
    }

    public T update(int id, Class<T> tClass, T object) {
        entityManager.getTransaction().begin();

        T result = entityManager.find(tClass, id);
        if (checkFindById(result)) {
            entityManager.getTransaction().commit();
            return null;
        }

        Field[] objFields = tClass.getDeclaredFields();
        Arrays.stream(objFields)
                .peek(q -> q.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    try {
                        field.set(result, field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        entityManager.merge(result);
        entityManager.flush();
        entityManager.getTransaction().commit();
        Printer.printSuccessfulUpdateMethodMessage();
        return object;
    }

    public int delete(int id, Class<T> tClass) {
        entityManager.getTransaction().begin();
        T object = entityManager.find(tClass, id);
        if (checkFindById(object)) {
            entityManager.getTransaction().commit();
            return 0;
        }
        entityManager.remove(object);
        entityManager.getTransaction().commit();
        Printer.printSuccessfulDeleteMethodMessage();
        return id;
    }

    private boolean checkFindById(T object) {
        if (null == object) {
            Printer.printNotFoundMessage();
            return true;
        }
        return false;
    }
}
