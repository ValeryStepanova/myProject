package application.dao;

public interface DAO<T> {

    void create(T object);
    int update(T object, int id) throws NoSuchFieldException, IllegalAccessException;

    int delete(int id);

    T read(int id);
}
