package DAO;

import DTO.User;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    Connection conn = null; // Kết nối tới sql server
    PreparedStatement ps = null; //Ném câu lệnh Query từ netbean sang sql server
    ResultSet rs = null;

    //Kiểm tra kết nối tới db
    public UserDAO() {
        DBContext dBContext = new DBContext();
        try {
            conn = dBContext.getConnection();
            System.out.println("succes");
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void updateUser(User user) {
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [User Name] = ?\n"
                    + "      ,[Date Of Birth] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Role] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[Password] = ?\n"
                    + " WHERE UserID = ?";

            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getDob());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getRole());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPassword());
            ps.setInt(9, user.getUserID());
            //Execute và return kết quả
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean updateUsers(User user) {
        boolean result = false;
        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [User Name] = ?\n"
                    + "      ,[Date Of Birth] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Role] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[Password] = ?\n"
                    + " WHERE UserID = ?";

            String sql2 = "";
            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getDob());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getRole());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPassword());
            ps.setInt(9, user.getUserID());
            //Execute và return kết quả
            ps.executeUpdate();
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        return result;
    }

    //Câu Lệnh Ảo Ma Update Cả 2 cùng lúc service and user
    public boolean update(User user) {
        boolean result = false;
        try {
            String sql = "UPDATE [dbo].[Service]\n"
                    + "   SET \n"
                    + "      [Service Phone] = ?\n"
                    + " WHERE [Service Phone] IN ( SELECT Phone FROM Users JOIN Service ON Phone = [Service Phone] WHERE UserID = ? )\n"
                    + "UPDATE [dbo].[Users]\n"
                    + "   SET [User Name] = ?\n"
                    + "      ,[Date Of Birth] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Role] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[Password] = ?\n"
                    + " WHERE UserID = ?";

            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);

            //Update Xong Thằng Service
            ps.setString(1, user.getPhone());
            ps.setInt(2, user.getUserID());

            //Tới Thằng User
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getDob());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getPhone());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getRole());
            ps.setString(9, user.getAddress());
            ps.setString(10, user.getPassword());
            ps.setInt(11, user.getUserID());
            //Execute và return kết quả
            ps.executeUpdate();
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        return result;
    }

    //Done
    public void createNewUser(User user) {
        try {
            String sql = "INSERT INTO [dbo].[Users]\n"
                    + "           ([User Name]\n"
                    + "           ,[Date Of Birth]\n"
                    + "           ,[Gender]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Email]\n"
                    + "           ,[Role]\n"
                    + "           ,[Address]\n"
                    + "           ,[Password])\n"
                    + "     VALUES (?,?,?,?,?,?,?,?)";

            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getDob());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getRole());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPassword());

            //Execute và return kết quả
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Done
    public void deleteUser(int id) {
        try {
            String sql = "DELETE [Order] WHERE CustomerID = ? DELETE Users WHERE UserID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet resultSet = ps.executeQuery();
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Done
    public boolean createNewUsers(User user) {
        boolean result = false;
        try {
            String sql = "INSERT INTO [dbo].[Users]\n"
                    + "           ([User Name]\n"
                    + "           ,[Date Of Birth]\n"
                    + "           ,[Gender]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Email]\n"
                    + "           ,[Role]\n"
                    + "           ,[Address]\n"
                    + "           ,[Password])\n"
                    + "     VALUES (?,?,?,?,?,?,?,?)";

            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getDob());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getRole());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPassword());

            //Execute và return kết quả
            ps.executeUpdate();
            result = true;
        } catch (Exception ex) {
            result = false;
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Done
    public List<User> getAllUser() {
        String sql = "SELECT * FROM Users";
        List<User> listUser = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = conn.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh 
            //ResultSet chứa bảng tạo câu lệnh 
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                //Lấy Value theo từng cột
                int userID;
                String name, dob, gender, phone, email, role, address, password;
                //Tạo model hứng dữ liệu
                userID = resultSet.getInt(1);
                name = resultSet.getString(2);
                dob = resultSet.getString(3);
                gender = resultSet.getString(4);
                phone = resultSet.getString(5);
                email = resultSet.getString(6);
                role = resultSet.getString(7);
                address = resultSet.getString(8);
                password = resultSet.getString(9);
                //Thêm Mới User
                User user = new User(userID, name, dob, gender, phone, email, role, address, password);
                listUser.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return listUser;
    }

    //Done
    public boolean checkLogin(String email, String password) {
        boolean isValid = false;
        try {
            String sql = "SELECT * FROM Users WHERE Email = ? AND [Password] = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet resultSet = pre.executeQuery();

            if (resultSet.next()) {
                isValid = true;
            } else {
                isValid = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    public User getUserByID(int id) {
        try {
            String sql = "SELECT * FROM Users WHERE UserID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Done
    public User getUserByEmail(String email) {
        try {
            String sql = "SELECT * FROM Users WHERE Email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Done
    public User getUserByName(String name) {
        try {
            String sql = "SELECT * FROM Users WHERE FullName = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        //boolean x = dao.checkLogin("hungdnbde160562@fpt.edu.vn", "kenkongu");
        //System.out.println(x);
        //System.out.println(dao.getUserByEmail("hungdnbde160562@fpt.edu.vn"));

//        User user = new User(106, "anh", "2002-01-01", "Male", "0905000000", "chibi@gmail.com", "SL", "Hoi An", "0404");
//        System.out.println(dao.updateUsers(user));
        User user = new User(120, "Ba Na Hill", "2000-01-01", "Unknown", "1900 0000", "BaNaHill@gmail.com", "SL", "Da Nang", "123");
        dao.update(user);
    }
}
