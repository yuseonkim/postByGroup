package Service;

import Entity.member;

import java.sql.*;

public class loginService {
    public Boolean getloginResult(String id, String pw) {
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "select pwd from member where id = ?";
        Boolean Answer = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String pw_ = rs.getString("pwd");
                if (pw.equals(pw_)) {
                    Answer = true;
                } else
                    Answer = false;
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Answer;

    }

    public member getMemberInfo(String id) {
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "select * from member where id= ?";
        member A = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String id_ = rs.getString("id");
                String pw_ = rs.getString("pwd");
                int mid_ = rs.getInt("mid");
                String name_ = rs.getString("name");
                int grade_ = rs.getInt("grade");

                A = new member(
                        id_, pw_, mid_, name_, grade_
                );
            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return A;

    }


}



