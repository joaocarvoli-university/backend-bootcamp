package br.mandacaru.class04.service;

import br.mandacaru.class04.dao.ProductMemoryDAO;
import br.mandacaru.class04.dao.ProductDAO;
import br.mandacaru.class04.model.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ProductDAO productDAO = new ProductMemoryDAO();

    public void save(int id, Product entity) {
        if(id != 0) {
            entity.setId(id);
        }
        productDAO.save(entity);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }

    public Product find(int id) {
        if(id < 1) {
            return null;
        }

        return productDAO.find(id);
    }

    public ArrayList<Product> findAll() {
        return productDAO.findAll();
    }

    public Product findByName(String str) {
        if(str.length() < 3) {
            return null;
        }

        return productDAO.findByName(str);
    }

    public ArrayList<Product> findAllByName(String str) {
        return productDAO.findAllByName(str);
    }
}

