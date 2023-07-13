/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ServiceDAO;
import DTO.Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Service;

public class AddServiceController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int price, quantity;
        String serviceName = request.getParameter("serviceName");
        String serviceAddress = request.getParameter("serviceAddress");
        String servicePhone = request.getParameter("servicePhone");
        String serviceQuantity = request.getParameter("serviceQuantity");
        String servicePrice = request.getParameter("servicePrice");
        
        ServiceDAO cdb = new ServiceDAO();
        quantity = Integer.parseInt(serviceQuantity);
        price = Integer.parseInt(servicePrice);
        Service cNew = new Service(0, serviceName, serviceAddress, servicePhone, quantity, price);
        cdb.insertService(cNew);
        
        response.sendRedirect("service");
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
