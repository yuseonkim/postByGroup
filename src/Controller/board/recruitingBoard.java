package Controller.board;

import Entity.team;
import Service.main.mainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/board/recruiting")
public class recruitingBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        mainService service = new mainService();
        int mid = Integer.parseInt(req.getParameter("mid"));
        ArrayList<team> recruitingBoards;
        recruitingBoards = service.getRecuritingTeam(mid);
        req.setAttribute("team",recruitingBoards);
        req.getRequestDispatcher("/WEB-INF/View/boards/recruitingBoard.jsp").forward(req,resp);


    }
}
