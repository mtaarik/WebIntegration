package org.example.model;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    // Constructeur par défaut (obligatoire pour JSON/XML)
    // constructeur avec les paramètres
    // Getters et Setters
    public Product() {
    }
    public Product(Long id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    // COMPLETER LES GETTERS ET LES SETTERS

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
