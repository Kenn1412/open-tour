/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Order {
    private int orderID;
    private String orderDate;
    private int orderCustomerID;
    private double orderTotalMoney;

    public Order() {
    }
    
    public Order(int orderID, String orderDate, int orderCustomerID, double orderTotalMoney) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderCustomerID = orderCustomerID;
        this.orderTotalMoney = orderTotalMoney;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderCustomerID() {
        return orderCustomerID;
    }

    public void setOrderCustomerID(int orderCustomerID) {
        this.orderCustomerID = orderCustomerID;
    }

    public double getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(double orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }
}
