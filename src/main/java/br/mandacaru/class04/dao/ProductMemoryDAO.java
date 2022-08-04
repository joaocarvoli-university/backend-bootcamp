package br.mandacaru.class04.dao;
import br.mandacaru.class04.model.Product;
import java.util.ArrayList;
import java.util.HashMap;


public class ProductMemoryDAO implements ProductDAO {

    private HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    int i = 0;

    @Override
    public void save(Product entity) {
        if(entity.getId() == 0) {
            i++;
            entity.setId(i);
        }

        products.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product find(int id) {
        return products.get(id);
    }

    @Override
    public ArrayList<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public Product findByName(String str) {
        for (Product product : products.values()) {
            if(product.getName().equals(str)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Product> findAllByName(String str) {
        ArrayList<Product> listProducts = new ArrayList<>();

        for (Product product : products.values()) {
            if(product.getName().equals(str)) {
                listProducts.add(product);
            }
        }

        return null;
    }
}
