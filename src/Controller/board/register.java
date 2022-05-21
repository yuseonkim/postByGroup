package Controller.board;

import Entity.member;
import Entity.team;
import Service.loginService;
import Service.main.mainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        mainService service = new mainService();
        loginService service2 = new loginService();
        int tid = Integer.parseInt(req.getParameter("tid"));
        int mid = Integer.parseInt(req.getParameter("mid"));
        member a = service2.getMemberInfoByMid(mid);
        team b = service2.getTeamInfo(tid);
        req.setAttribute("member", a);
        req.setAttribute("team", b);
        int checkAlready = service.checkAlreadyOrder(tid, mid);
        if (checkAlready == 1) {
            req.getRequestDispatcher("/WEB-INF/View/boards/already.jsp").forward(req, resp);
        } else {
            int result = service.registerService(tid, mid);

            req.getRequestDispatcher("/WEB-INF/View/boards/registerSuccess.jsp").forward(req, resp);
        }
    }
}
