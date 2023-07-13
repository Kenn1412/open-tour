/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Service;
import DTO.User;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ServiceDAO {

    Connection conn = null; // Kết nối tới sql server
    PreparedStatement ps = null; //Ném câu lệnh Query từ netbean sang sql server
    ResultSet rs = null;

    public ServiceDAO() {
        DBContext dBContext = new DBContext();
        try {
            conn = dBContext.getConnection();
            System.out.println("succes");
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public List<Service> getAll() {
        String sql = "Select * from [Service]";
        List<Service> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = conn.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh 
            //ResultSet chứa bảng tạo câu lệnh 
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                //Lấy Value theo từng cột
                int serviceID = resultSet.getInt(1);
                String serviceName = resultSet.getString(2);
                String serviceAddress = resultSet.getString(3);
                String servicePhone = resultSet.getString(4);
                int serviceQuantity = resultSet.getInt(5);
                int servicePrice = resultSet.getInt(6);

                Service service = new Service(serviceID, serviceName, serviceAddress, servicePhone, serviceQuantity, servicePrice);
                list.add(service);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;
    }

    public List<Service> getAllServiceByPhone(String phone) {
        String sql = "SELECT * FROM [Service] where [Service Phone] = ?";
        List<Service> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = conn.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh 
            //Set dấu ? là 1 sđt
            pre.setString(1, phone);
            //ResultSet chứa bảng tạo câu lệnh 
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                //Lấy Value theo từng cột
                int serviceID = resultSet.getInt(1);
                String serviceName = resultSet.getString(2);
                String serviceAddress = resultSet.getString(3);
                String servicePhone = resultSet.getString(4);
                int serviceQuantity = resultSet.getInt(5);
                int servicePrice = resultSet.getInt(6);

                Service service = new Service(serviceID, serviceName, serviceAddress, servicePhone, serviceQuantity, servicePrice);
                list.add(service);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;
    }

    public Service getServiceByID(int id) {
        try {
            String sql = "Select * from Service where ServiceID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Service(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    ///////////////////////////////////////Code Của Phong //////////////////////////////////////////
    public List<Service> getListService() {
        List<Service> list = new ArrayList<>();
        String sql = "select * from Service";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service c = new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertService(Service c) {
        String sql = "INSERT INTO [Service]\n"
                + "           ([Service Name]\n"
                + "           ,[Service Address]\n"
                + "           ,[Service Phone]\n"
                + "           ,[Service Quantity]\n"
                + "           ,[Service Price])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getServiceName());
            st.setString(2, c.getServiceAddress());
            st.setString(3, c.getServicePhone());
            st.setInt(4, c.getServiceQuantity());
            st.setInt(5, c.getServicePrice());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteService(int keyword) {
        String sql = "DELETE FROM [Service]\n"
                + "      WHERE ServiceID=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, keyword);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //??
    public void updateBook(Service c) {
        String sql = "UPDATE [Service]\n"
                + "   SET \n"
                + "      [Service Name] = ?\n"
                + "      ,[Service Address] = ?\n"
                + "      ,[Service Phone] = ?\n"
                + "      ,[Service Quantity] = ?\n"
                + "      ,[Service Price] = ?\n"
                + " WHERE ServiceID=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(6, c.getServiceID());
            st.setString(1, c.getServiceName());
            st.setString(2, c.getServiceAddress());
            st.setString(3, c.getServicePhone());
            st.setInt(4, c.getServiceQuantity());
            st.setInt(5, c.getServicePrice());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //Admin
    public List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        String sql = "select * from users";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User c = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ServiceDAO dao = new ServiceDAO();
//        List<Service> list = dao.getAll();
//        for (Service s : list) {
//            System.out.println(s);
//        }
        Service c = new Service(0, "a", "a", "1", 1, 1);
         dao.deleteService(9);
    }
}
