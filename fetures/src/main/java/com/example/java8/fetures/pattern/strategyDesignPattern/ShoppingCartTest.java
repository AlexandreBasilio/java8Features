package com.example.java8.fetures.pattern.strategyDesignPattern;

/*
 Strategy pattern is used when we have multiple algorithm for a specific task and
  client decides the actual implementation to be used at runtime.

   One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter.
   Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.


   we will try to implement a simple Shopping Cart where we have two payment strategies - using Credit Card or using PayPal.
 */
public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("alex@yahoo.com", "aa"));
        cart.pay(new CreditcardStrategy("alex", "90887", "302", "2021/10"));
    }
}
