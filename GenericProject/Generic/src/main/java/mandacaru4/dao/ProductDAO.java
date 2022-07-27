package mandacaru4.dao;
import mandacaru4.entities.Product;
import java.util.ArrayList;

public interface ProductDAO {
    void save(Product product);
    void delete(int id);
    Product find(int id);
    ArrayList<Product> findAll();
    Product findByName(String str);
    ArrayList<Product> findAllByName(String str);
}
