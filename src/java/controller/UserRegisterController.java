package controller;

import DAO.UserDAO;
import DTO.User;
import context.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserRegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegisterController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String address = request.getParameter("address");
        String pass = request.getParameter("pass");
        String cfpass = request.getParameter("cfpass");

        UserError userError = new UserError();

        boolean check = true;

        //Kiểm tra các lỗi 

        if (!pass.equals(cfpass)) {
            userError.setPasswordError("Password and ConfirmPassword must be the one !!");
            check = false;
        }
        //Dừng kiểm tra lỗi
        
        
        if (check) {
            User newUser = new User(0, name, dob, gender, phone, email, role, address, pass);
            UserDAO dao = new UserDAO();
            if (dao.getUserByEmail(email) != null) {
                request.setAttribute("msg", "Email Alredy Sign Up !! Try Another Email ");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                if (dao.createNewUsers(newUser)) {
                    request.setAttribute("msg", "Register successfully!");
                } else {
                    request.setAttribute("msg", "Register Error!");
                }
                request.setAttribute("msg", "Register successfully!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("userError", userError);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
