import dao.ProductHibernateDAO;
import entities.Product;

public class Main {
    public static void main(String[] args) {
        /*Product prod01 = new Product(0, "geladeira", 2300);
        ProductJDBCDAO productDAO = new ProductJDBCDAO();
        //productDAO.save(prod01);
        System.out.println(productDAO.find(2));
        productDAO.delete(2);
        for(Product prod: productDAO.findAll()){
            System.out.println(prod);
        }*/
        //EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru");
        //sessionFactory.close();

        Product prod01 = new Product(0, "liquidificador", 190);
        ProductHibernateDAO productDAO = new ProductHibernateDAO();
        productDAO.save(prod01);
        //productDAO.delete(2);
        for(Product prod: productDAO.findAll()){
            System.out.println(prod);
        }
    }
}
