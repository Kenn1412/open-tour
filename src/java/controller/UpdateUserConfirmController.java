/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UserDAO;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserConfirmController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        User user = (User) request.getSession().getAttribute("user");
        
        String userName, dob, gender, phone, email, role, address, password;
        userName = request.getParameter("name");
        dob = request.getParameter("dob");
        gender = request.getParameter("gender");
        phone = request.getParameter("phone");
        email = request.getParameter("email");
        role = request.getParameter("role");
        address = request.getParameter("address");
        password = request.getParameter("pass");
        
        User updateUser = new User(user.getUserID(), userName, dob, gender, phone, email, role, address, password);
        UserDAO dao = new UserDAO();
        
        user.setUserName(userName);
        user.setDob(dob);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(role);
        user.setAddress(address);
        user.setPassword(password);

        //if (dao.updateUsers(updateUser)) {
        if (dao.update(updateUser)) {
            request.setAttribute("msg", "Update successfully!");
        } else {
            request.setAttribute("msg", "Update Failse!");
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
