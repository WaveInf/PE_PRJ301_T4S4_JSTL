/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Cart {

    private HashMap<String, ProductDTO> cart;

    public Cart() {
    }

    public Cart(HashMap<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public boolean add(String id, ProductDTO product) {
        boolean check = false;
        try {           
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(id)) {
                int currentQuantity = this.cart.get(id).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(id, product);
            check = true;
        } catch (Exception e) {

        } finally {
            return check;
        }
    }
    
    public boolean remove(String id) {
        boolean check = false;
        try {           
            if (this.cart != null) {
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check = true;
                }
            }

        } catch (Exception e) {

        } finally {
            return check;
        }
    }

    public boolean edit(String id, ProductDTO product) {
        boolean check = false;
        try {           
            if (this.cart != null) {
                if(this.cart.containsKey(id)){
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {

        } finally {
            return check;
        }
    }

}
