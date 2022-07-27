package app.dao;

import app.entities.Property;
import java.util.ArrayList;

public interface PropertiesDAO {
    void save(Property property);
    void delete(int id);
    Property find(int id);
    Property findByName(String str);
    ArrayList<Property> findAll();
    ArrayList<Property> findAllByName(String str);
}
