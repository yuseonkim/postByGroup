package Service;

import Entity.member;
import Entity.team;

import java.sql.*;

public class loginService {
    public Boolean getloginResult(String id, String pw) {
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
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
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
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

    public member getMemberInfoByMid(int mid) {
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from member where mid= ?";
        member A = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, mid);
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
    public team getTeamInfo(int tid) {
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from team where tid= ?";
        team a = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, tid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
               int tid_ = rs.getInt("tid");
               String tname_ = rs.getString("tname");
               int masterId = rs.getInt("masterId");

               a = new team(tid_,tname_,masterId);

            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return a;

    }


}



