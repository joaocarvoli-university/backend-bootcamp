package mandacaru4.dao;

import mandacaru4.entities.Product;
import java.util.ArrayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductHibernateDAO implements ProductDAO {

    static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru4");
    static EntityManager entityManager;

    @Override
    public void save(Product entity) {
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        if (entity.getId() == 0) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        entityManager = sessionFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Product find(int id) {
        entityManager = sessionFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        entityManager.close();

        return product;
    }

    @Override
    public ArrayList<Product> findAll() {
        entityManager = sessionFactory.createEntityManager();
        ArrayList<Product> products = (ArrayList<Product>) entityManager.createQuery("from products", Product.class).getResultList();
        entityManager.close();

        return products;
    }

    @Override
    public Product findByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        Product product = null;

        try {
            product = entityManager.createQuery("from products where name=?1", Product.class).setParameter(1, str)
                    .setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();

        return product;
    }

    @Override
    public ArrayList<Product> findAllByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        ArrayList<Product> products;

        try {
            products = (ArrayList<Product>) entityManager.createQuery("from products where name=?1", Product.class)
                    .setParameter(1, str).getResultList();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();

        return products;
    }
}
