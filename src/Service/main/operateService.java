package Service.main;

import java.sql.*;

public class operateService {
    public int operateTeam(String tname,int mid) {//중복확인메서드
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "insert into team(tname,masterId) values(?,?);";
        int result = -1; //오류발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,tname);
            st.setInt(2,mid);
            result = st.executeUpdate();

            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int checkAlltname(String tname) {//중복확인메서드
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select tname from team where tname= ?;";
        int result = -1; //오류발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tname);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = 1; //존재할경우
            } else {
                result = 0;
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
