package kz.ticketon.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/register?regError";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User checkUser = DBManager.getUser(email);
        if(checkUser == null){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            if(DBManager.addUser(user)){
                redirect = "/login";
            }
        }
        resp.sendRedirect(redirect);


    }
}
