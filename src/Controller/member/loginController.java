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
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        loginService service = new loginService();
        /*로그인결과로 True를 반환한다면 ,
        로그인실패 화면을 띄우면서 다시 index.jsp 반환
         */
        if(service.getloginResult(id,pw)){
            req.getRequestDispatcher("/main").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
