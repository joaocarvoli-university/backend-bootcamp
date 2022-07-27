package app.dao;

import app.entities.Property;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class PropertiesHibernateDAO implements PropertiesDAO{
    static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("app");
    static EntityManager entityManager;

    @Override
    public void save(Property property) {
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        if(property.getId() == 0){
            entityManager.persist(property);
        } else {
            entityManager.merge(property);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        entityManager = sessionFactory.createEntityManager();
        Property property = entityManager.find(Property.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(property);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Property find(int id) {
        entityManager = sessionFactory.createEntityManager();
        Property property = entityManager.find(Property.class, id);
        entityManager.close();
        return property;
    }

    @Override
    public Property findByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        Property property = null;

        try {
            property = entityManager.createQuery("from properties where name=?1", Property.class).setParameter(1, str)
                    .setMaxResults(1).getSingleResult();
        } catch (Exception e){
            return null;
        }
        entityManager.close();
        return property;
    }

    @Override
    public ArrayList<Property> findAll() {
        entityManager = sessionFactory.createEntityManager();
        ArrayList<Property> property = (ArrayList<Property>) entityManager.createQuery("from properties", Property.class).getResultList();
        entityManager.close();
        return property;
    }

    @Override
    public ArrayList<Property> findAllByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        ArrayList<Property> property = null;

        try {
            property = (ArrayList<Property>) entityManager.createQuery("from properties where name=?1", Property.class).setParameter(1, str)
                    .setParameter(1, str).getResultList();
        } catch (Exception e){
            return null;
        }
        entityManager.close();
        return property;
    }
}
