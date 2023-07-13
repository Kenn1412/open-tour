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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phong
 */
public class UpdateServiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("keyword");
        int idd;
        ServiceDAO cdb = new ServiceDAO();
        try {
            idd = Integer.parseInt(id);
            Service c = cdb.getServiceByID(idd);
            request.setAttribute("service", c);
            request.getRequestDispatcher("updateService.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id, price, quantity;
        String serviceID = request.getParameter("serviceID");
        String serviceName = request.getParameter("serviceName");
        String serviceAddress = request.getParameter("serviceAddress");
        String servicePhone = request.getParameter("servicePhone");
        String serviceQuantity = request.getParameter("serviceQuantity");
        String servicePrice = request.getParameter("servicePrice");
        ServiceDAO cdb = new ServiceDAO();
        try {
            id = Integer.parseInt(serviceID);
            quantity = Integer.parseInt(serviceQuantity);
            price = Integer.parseInt(servicePrice);
            Service c = cdb.getServiceByID(id);
            Service cNew = new Service(id, serviceName, serviceAddress, servicePhone, quantity, price);
            cdb.updateBook(cNew);
            response.sendRedirect("service");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
