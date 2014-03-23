/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aqs.controller;

import com.aqs.model.Product;
import com.aqs.system.ProductNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Edgard Davidson
 */
public class ShoppingCart {

     private ArrayList _items;

   public ShoppingCart() {
      _items = new ArrayList();
   }

   public double getBalance()
   {
      Iterator i = _items.iterator();
      double balance = 0.00;
      while (i.hasNext()) {
         Product p = (Product)i.next();
         balance = balance + p.getPrice();
      }

      return balance ;
   }

   /* puts the specified item in the cart*/
   @SuppressWarnings("unchecked")
   public void addItem(Product p)
   
   {
      _items.add(p);
   }


   public void removeItem(Product p) throws ProductNotFoundException
   /* remove the specified item from the cart
   */
   {
      if (!_items.remove(p)) {
         throw new ProductNotFoundException();
      }
   }

   public int getItemCount()
   /* Returns the number of items in the cart.
   */
   {
      return _items.size();
   }

   public void empty()
   /* remove all items from the cart
   */
   {
      _items = new ArrayList();
   }

   public boolean isEmpty()
   /* Determines whether the cart is empty.
      @return true if the cart is empty;
	      false otherwise.
   */
   {
      return (_items.size() == 0);
   }


}
