package mx.edev.crud.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Lombok annotation that automatically adds the setters & getters for all attributes in the class
@Data
@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private boolean available;

    public Product() {
    }

    public Product(String name, String description, boolean available) {
        this.name = name;
        this.description = description;
        this.available = available;
    }
}