/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Cart;
import DTO.Item;
import DTO.User;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class OrderDAO {

    Connection conn = null; // Kết nối tới sql server
    PreparedStatement ps = null; //Ném câu lệnh Query từ netbean sang sql server
    ResultSet rs = null;

    public OrderDAO() {
        DBContext dBContext = new DBContext();
        try {
            conn = dBContext.getConnection();
            System.out.println("succes");
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void addOrder(User u, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String sql = "Insert Into [Order] values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setInt(2, u.getUserID());
            ps.setDouble(3, cart.getTotalMoney());
            ps.execute();

            String sql1 = "SELECT TOP 1 OrderID from [Order] order by OrderID DESC";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            rs = ps1.executeQuery();
            //Add Vào bảng OrderDetail
            if (rs.next()) {
                int orderID = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO OrderLine values(?,?,?,?)";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setInt(1, orderID);
                    ps2.setInt(2, i.getService().getServiceID());
                    ps2.setInt(3, i.getQuantity());
                    ps2.setDouble(4, i.getPrice());
                    ps2.executeUpdate();
                }
            }
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
    }
}
