/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ServiceDAO;
import DTO.Cart;
import DTO.Item;
import DTO.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UserBuy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        //Tạo biến Cart
        Cart cart = null;
        
        Object o = session.getAttribute("cart");

        //Cách Khác
        //Cart carts = (Cart) session.getAttribute("cart");
        
        //có Cart rồi
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String tnum = request.getParameter("num");
        String tid = request.getParameter("id");
        int num, id;
        try {
            num = Integer.parseInt(tnum);
            id = Integer.parseInt(tid);

            ServiceDAO svd = new ServiceDAO();
            Service service = svd.getServiceByID(id);
            double price = service.getServicePrice() * 1.2; //Tăng sản phẩm thêm 1,2%
            Item t = new Item(service, num, price);
            cart.addItem(t);
        } catch (Exception e) {
            num = 1;
        }

        List<Item> list = cart.getItems();
        //Set cái giỏ  hàng trên session ( đi đâu cx gặp cũng lấy được nó ra)
        session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());
        request.getRequestDispatcher("daNang.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
