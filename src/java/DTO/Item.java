package DTO;

import java.util.Date;

public class Item {
    
    private Service service;
    private int quantity;
    private double price;
//  Xử Lí thời gian mua ticket
//    private Date dateTravel;

    public Item() {
    }
    

    public Item(Service service, int quantity, double price) {
        this.service = service;
        this.quantity = quantity;
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
