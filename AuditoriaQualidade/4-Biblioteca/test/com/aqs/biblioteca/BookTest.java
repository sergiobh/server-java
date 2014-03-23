/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aqs.biblioteca;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sérgio
 */
public class BookTest {
    
    Book book;
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        book = new Book("Sei não posso não", "Sérgio Macedo");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addToWaitList method, of class Book.
     */
    @Test
    public void testAddToWaitList() throws Exception {
    }

    /**
     * Test of removeFromWaitList method, of class Book.
     */
    @Test
    public void testRemoveFromWaitList() throws Exception {
    }

    /**
     * Test of checkout method, of class Book.
     */
    @Test
    public void testCheckout() throws Exception {
    }

    /**
     * Test of checkin method, of class Book.
     */
    @Test
    public void testCheckin() throws Exception {
    }

    /**
     * Test of getNumberAvailable method, of class Book.
     */
    @Test
    public void testGetNumberAvailable() {
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
    }

    /**
     * Test of isInCheckoutList method, of class Book.
     */
    @Test
    public void testIsInCheckoutList() {
    }

    /**
     * Test of isInWaitList method, of class Book.
     */
    @Test
    public void testIsInWaitList() {
    }

    /**
     * Test of addACopy method, of class Book.
     */
    @Test
    public void testAddACopy() {
    }

    /**
     * Test of removeACopy method, of class Book.
     */
    @Test
    public void testRemoveACopy() {
    }

    /**
     * Test of getPidWaitList method, of class Book.
     */
    @Test
    public void testGetPidWaitList() {
    }

    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
    }

    /**
     * Test of getSizeOfWaitList method, of class Book.
     */
    @Test
    public void testGetSizeOfWaitList() {
    }

    /**
     * Test of getSizeOfCheckoutList method, of class Book.
     */
    @Test
    public void testGetSizeOfCheckoutList() {
    }

    /**
     * Test of nextWaiting method, of class Book.
     */
    @Test
    public void testNextWaiting() {
    }

    /**
     * Test of getNumberCheckedOut method, of class Book.
     */
    @Test
    public void testGetNumberCheckedOut() {
    }
    
}
