/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aqs.controller;

/**
 *
 * @author Edgard Davidson
 */
public class Sale {
    ShoppingCart _shoppingCart;
    double _discount ;

    public Sale(ShoppingCart shoppingCart) {
        this._shoppingCart = shoppingCart;
    }

    Sale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getTotalSaleValueWithoutDiscount(){
        return this._shoppingCart.getBalance();
    }

    public void setDiscount(double discount) {
        this._discount = discount;
    }

    public double getTotalSaleValueWithDiscount(){
        double value  = this._shoppingCart.getBalance();
        return value -  ((value * this._discount) / 100) ;
    }
}
