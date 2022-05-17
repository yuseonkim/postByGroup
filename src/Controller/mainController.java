package Controller;

import Entity.member;
import Service.loginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/main")
public class mainController extends HttpServlet {
    @Override
    /*
    게시글리스트
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginService service = new loginService();
        String id = req.getParameter("id");
        member a = service.getMemberInfo(id);
        req.setAttribute("member",a);
        req.getRequestDispatcher("WEB-INF/View/main.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
