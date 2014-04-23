/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aqs.controller;

import com.aqs.model.Product;
import com.aqs.system.ProductNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edgard.cardoso
 */
public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    public ShoppingCartTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.shoppingCart = new ShoppingCart();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class ShoppingCart.
     */
    @Test
    public void testGetBalance() {
        shoppingCart.addItem(new Product("CD", 10.99));
        shoppingCart.addItem(new Product("DVD", 19.90));
        shoppingCart.addItem(new Product("Livro", 49.90));
        shoppingCart.addItem(new Product("pen drive", 49.00));
        
        assertEquals("O valor deveria ser 129.79" , 129.79, shoppingCart.getBalance(), 0.01d);
    }

    /**
     * Test of addItem method, of class ShoppingCart.
     */
    @Test
    public void testAddItem() {
        shoppingCart.addItem(new Product("CD", 10.99));
        assertEquals("deveria ter 1 produto", 1, shoppingCart.getItemCount());

        shoppingCart.addItem(new Product("DVD", 19.90));
        shoppingCart.addItem(new Product("Livro", 49.90));
        shoppingCart.addItem(new Product("pen drive", 49.00));

        assertEquals("Deveria ter 4 produtos", 4, shoppingCart.getItemCount());
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     */
    @Test
    public void testRemoveItem() {
        try {
            Product dvd = new Product("DVD", 19.90);
            Product livro = new Product("Livro", 49.90);
            Product pendrive = new Product("pen drive", 49.00);

            shoppingCart.addItem(dvd);
            shoppingCart.addItem(livro);
            shoppingCart.addItem(pendrive);

            assertEquals("Deveria ter 3 produtos", 3, shoppingCart.getItemCount());

            shoppingCart.removeItem(dvd);
            shoppingCart.removeItem(pendrive);

            assertEquals("Deveria ter 1 produtos", 1, shoppingCart.getItemCount());

            shoppingCart.removeItem(livro);
            assertTrue("Deveria estar vazio", shoppingCart.isEmpty());

            shoppingCart.removeItem(dvd);
            fail("nao deveria ter passado aqui");

        } catch (ProductNotFoundException pnfe) {
            // entao esta tudo certo        
        } catch (Exception e) {
            fail("erro inesperado " + e.getMessage());
        }

    }

    /**
     * Test of getItemCount method, of class ShoppingCart.
     */
    @Test
    public void testGetItemCount() {
    }

    /**
     * Test of empty method, of class ShoppingCart.
     */
    @Test
    public void testEmpty() {
    }

    /**
     * Test of isEmpty method, of class ShoppingCart.
     */
    @Test
    public void testIsEmpty() {
    }

}
