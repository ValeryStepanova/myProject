package application.dao.daoClasses;

import application.dao.daoInterfaces.DoorDAO;
import application.entity.Door;

import javax.persistence.EntityManager;

public class DAOImplDoor extends DAOImpl<Door> implements DoorDAO {

    public DAOImplDoor(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Door door) {
        super.create(door);
    }

    @Override
    public Door read(int id) {
        return super.read(id, Door.class);
    }

    @Override
    public int update(Door newDoor, int id) {
        return super.update(id, Door.class, newDoor).getId();
    }

    @Override
    public int delete(int id) {
        return super.delete(id, Door.class);
    }
}
