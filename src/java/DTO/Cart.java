package DTO;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;

    //Getter Setter
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    //End Getter Setter
    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    //Muốn Xóa Hay thêm phải thông qua
    private Item getItemById(int id) {
        for (Item i : items) {
            if (i.getService().getServiceID() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    //Thêm vào giỏ hàng (CART)
    public void addItem(Item t) {
        //Có ở Cart rồi
        if (getItemById(t.getService().getServiceID()) != null) {
            Item i = getItemById(t.getService().getServiceID());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            //Chưa có trong cart
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += i.getQuantity() * i.getPrice();
        }
        return t;
    }
}
