package Controller.board;

import Service.main.operateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/board/tnameCheck")
public class tnameCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tname = req.getParameter("id");
        operateService service = new operateService();
        int result = service.checkAlltname(tname);//중복일경우 1, 없을 경우 0 반환

        req.setAttribute("tname",tname);
        req.setAttribute("result",result);
        req.getRequestDispatcher("/WEB-INF/View/boards/tnameCheckForm.jsp").forward(req,resp);
    }
}
