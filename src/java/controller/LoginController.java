package controller;

import DAO.UserDAO;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    private final String CUSTOMER_PAGE = "customerPage.jsp";
    private final String SELLER_PAGE = "service";
    private final String ADMIN_PAGE = "AdminShowListUserController";
    private final String ERROR_PAGE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Lấy 2 tham chiếu từ trang login.jsp
        String email = request.getParameter("txtEmail");
        String pass = request.getParameter("txtPassword");

        //Tạo liên kết với UserDao
        UserDAO dao = new UserDAO();
        //Vào Database kiểm tra email và pass có hợp lệ chưa

        if (dao.checkLogin(email, pass)) {
            User user = new UserDAO().getUserByEmail(email);
            // int userID = user.getUserID();
            HttpSession session = request.getSession();
            //gửi đi thằng người dùng
            session.setAttribute("user", user);
            String url = ERROR_PAGE;
            if (user.getRole().equals("AD")) {
                url = ADMIN_PAGE;
            } else if (user.getRole().equals("SL")) {
                url = SELLER_PAGE;
            } else if (user.getRole().equals("CS")) {
                url = CUSTOMER_PAGE;
            }
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            String msg = "In correct password or email !!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
