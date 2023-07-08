/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OrderDTO {
    private String orderID;
    private String userID;
    private String productName; 
    private double price;
    private int quantity;    
    private String date;

    
    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, String productName, double price, int quantity, String Date) {
        this.orderID = orderID;
        this.userID = userID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}
