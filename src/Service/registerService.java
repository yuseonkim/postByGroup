package Service;

import Entity.member;

import java.sql.*;

public class registerService {

    public int checkAllId(String id) {//중복확인메서드
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "select id from member where id= ?";
        int result = -1; //오류발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
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

    public int registerService(String name, int grade, String depart, String id, String pwd) {//중복확인메서드
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "insert into member(name,grade,depart,id,pwd) values(?,?,?,?,?)";
        int result = -1; //오류발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, grade);
            st.setString(3, depart);
            st.setString(4, id);
            st.setString(5, pwd);
            result = st.executeUpdate();


            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

