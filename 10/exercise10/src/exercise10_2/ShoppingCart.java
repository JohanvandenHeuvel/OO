/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10_2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class ShoppingCart {

    List<Item> items;
    boolean paid = false;
    PaymentMethod pm;
    
    public ShoppingCart() {
        this.items = new LinkedList<>();
        this.pm = new IDeal("Rabobank", 1234, 999);
    }

    public ShoppingCart(PaymentMethod pm) {
        this.items = new LinkedList<>();
        this.pm = pm;
    }

    /**
     * Add item to cart
     */
    boolean add(Item item) {
        if (pm.pay(item.price)) {
            items.add(item);
            return true;
        } 
        return false;
    }

    /**
     * Remove item from cart
     */
    void remove(Item item) {
        items.remove(item);
    }

    double totalPrice() {
        double sum = items.stream().mapToDouble(Item::getPrice).sum();
        double shipping = items.stream().map(i -> i.shippingCost()).collect(Collectors.toSet()).stream().mapToDouble(Double::doubleValue).sum();
        return sum + shipping;
    }

    void changePaymentMethod(PaymentMethod pm) {
        this.pm = pm;
    }
}
