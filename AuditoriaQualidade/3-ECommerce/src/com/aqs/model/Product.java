/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqs.model;

/**
 *
 * @author Edgard Davidson
 */
public class Product {

    private String _title;
    private double _price;

    public Product(String title, double price) {
        _title = title;
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    public double getPrice() {
        return _price;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product) o;
        return p.getTitle().equals(_title);
    }
}
