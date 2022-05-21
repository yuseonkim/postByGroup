package Controller.member;

import Entity.member;
import Service.loginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        loginService service = new loginService();
        /*로그인결과로 True를 반환한다면 ,
        로그인실패 화면을 띄우면서 다시 index.jsp 반환
         */
        if (service.getloginResult(id, pw)) {
            member a;
            a = service.getMemberInfo(id);
            req.setAttribute("member",a);
            req.getRequestDispatcher("/WEB-INF/View/main.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
