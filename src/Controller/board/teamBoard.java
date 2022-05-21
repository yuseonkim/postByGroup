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

@WebServlet("/board/team")
public class teamBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        mainService service= new mainService();
        int mid = Integer.parseInt(req.getParameter("mid"));
        ArrayList<team> teamBoards;
        teamBoards = service.getTeamByMember(mid);
        req.setAttribute("team",teamBoards);
        req.getRequestDispatcher("/WEB-INF/View/boards/teamBoard.jsp").forward(req,resp);
    }
}
