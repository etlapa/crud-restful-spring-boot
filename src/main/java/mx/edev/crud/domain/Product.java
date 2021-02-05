package mx.edev.crud.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Product {
    private Long id;
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