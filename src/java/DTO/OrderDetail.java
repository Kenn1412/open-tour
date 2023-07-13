package DTO;

public class OrderDetail {
    
    private int orderID, serviceID;
    private int quantity;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int orderID, int serviceID, int quantity, double price) {
        this.orderID = orderID;
        this.serviceID = serviceID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
