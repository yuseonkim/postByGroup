package Controller.member;

import Service.loginService;
import Service.registerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/member/idCheck")
public class idCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            registerService service = new registerService();
            int result = service.checkAllId(id);//중복일경우 1, 없을 경우 0 반환

            req.setAttribute("result",result);
            req.setAttribute("id",id);
            req.getRequestDispatcher("/WEB-INF/View/member/idCheckForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
