package Controller.board;

import Service.main.operateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/board/insertTeam")
public class insertTeam extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int mid = Integer.parseInt(req.getParameter("mid"));
        String tname = req.getParameter("id");
        operateService service = new operateService();
        int result = service.operateTeam(tname,mid);
        req.setAttribute("mid",mid);
        req.getRequestDispatcher("/WEB-INF/View/boards/teamSuccess.jsp").forward(req,resp);


    }
}
