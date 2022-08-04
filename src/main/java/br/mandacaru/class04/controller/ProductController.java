package br.mandacaru.class04.controller;
import br.mandacaru.class04.model.Product;
import br.mandacaru.class04.service.ProductService;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<ArrayList<Product>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Product> find(@PathVariable("id") int id) {
        Product product = service.find(id);
        if(product != null) {
            return new ResponseEntity<>(service.find(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/search")
    public ResponseEntity<Product> findByName(@RequestParam("name") String name) {
        Product product = service.findByName(name);

        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        service.save(0, product);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") int id, @RequestBody Product product) {
        service.save(id, product);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
