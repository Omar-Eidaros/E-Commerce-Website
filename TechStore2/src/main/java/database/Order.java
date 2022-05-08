/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Omar Samir
 */
public class Order {

    private int orderId;
    private int userId;
    private ArrayList<Integer> orderItems;
    private int totalprice;
    private Date orderdate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Integer> getProductIds() {
        return this.orderItems;
    }

    public void setProductIds(ArrayList<Integer> items) {
        this.orderItems = items;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getOrderDate() {
        return this.orderdate;
    }

}
