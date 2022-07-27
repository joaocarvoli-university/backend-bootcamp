package app.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import app.dao.PropertiesDAO;
import app.dao.PropertiesHibernateDAO;
import app.entities.Property;
import java.util.ArrayList;

@Path("/properties")
public class PropertyController {
    PropertiesDAO propertyDAO = new PropertiesHibernateDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Property> getAllProducts(){
        return propertyDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Property getById(@PathParam("id") int id){
        return propertyDAO.find(id);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Property getByName(@QueryParam("title") String title){
        return propertyDAO.findByName(title);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addProduct(@FormParam("title") String title, @FormParam("address") String address,
                           @FormParam("squaredMetersBuilt") double squaredMetersBuilt,
                           @FormParam("squaredMetersLand") double squaredMetersLand,
                           @FormParam("bathroomsAmount") int bathroomsAmount,
                           @FormParam("parkingSpacesAmount") int parkingSpacesAmount) {

        Property property = new Property(0, title, address, squaredMetersBuilt, squaredMetersLand,
                bathroomsAmount, parkingSpacesAmount);
        System.out.println(property);
        propertyDAO.save(property);

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateProduct(@PathParam("id") int id, @FormParam("title") String title, @FormParam("address") String address,
                              @FormParam("squaredMetersBuilt") double squaredMetersBuilt,
                              @FormParam("squaredMetersLand") double squaredMetersLand,
                              @FormParam("bathroomsAmount") int bathroomsAmount,
                              @FormParam("parkingSpacesAmount") int parkingSpacesAmount) {

        Property property = new Property(id, title, address, squaredMetersBuilt, squaredMetersLand,
                bathroomsAmount, parkingSpacesAmount);
        propertyDAO.save(property);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        propertyDAO.delete(id);
    }
}