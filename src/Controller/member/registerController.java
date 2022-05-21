package Controller.member;

import Service.registerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Success")
public class registerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        int grade = Integer.parseInt(req.getParameter("grade"));
        String depart = req.getParameter("depart");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        registerService service = new registerService();
        int a  = service.registerService(name,grade,depart,id,pwd);

        req.getRequestDispatcher("/WEB-INF/View/member/registerSuccess.jsp").forward(req,resp);

    }
}
