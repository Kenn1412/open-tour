/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ServiceDAO;
import DTO.Service;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CheckUpdateDeleteServiceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckUpdateDeleteServiceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckUpdateDeleteServiceController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ServiceDAO d = new ServiceDAO();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");
        request.setAttribute("user", user);
        if (action.equals("add")) {
            request.getRequestDispatcher("addService.jsp").forward(request, response);
        }
        if (action.equals("delete")) {
            String s = request.getParameter("serviceID");
            int k;
            try {
                k = Integer.parseInt(s);
                d.deleteService(k);
                response.sendRedirect("service");
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        if (action.equals("update")) {
            String s = request.getParameter("serviceID");
            int k;
            try {
                k = Integer.parseInt(s);
                Service b = d.getServiceByID(k);
                request.setAttribute("service", b);
                request.getRequestDispatcher("updateService.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
