package kz.ticketon.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/login?emailError";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = DBManager.getUser(email);
        if(user!=null){
            redirect = "/login?passwordError";
            if(user.getPassword().equals(password)){
                redirect = "/home";
            }
        }
        resp.sendRedirect(redirect);
    }
}
