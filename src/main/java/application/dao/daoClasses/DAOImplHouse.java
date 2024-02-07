package application.dao.daoClasses;

import application.dao.daoInterfaces.HouseDAO;
import application.entity.House;

import javax.persistence.EntityManager;

public class DAOImplHouse extends DAOImpl<House> implements HouseDAO {

    public DAOImplHouse(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(House house) {
        super.create(house);
    }

    @Override
    public int update(House newHouse, int id)  {
        return super.update(id, House.class, newHouse).getId();
    }

    @Override
    public int delete(int id) {
        return super.delete(id, House.class);
    }

    @Override
    public House read(int id) {
        return super.read(id, House.class);
    }
}
