package Service.main;

import Entity.team;

import java.sql.*;
import java.util.ArrayList;

public class mainService {

    //특정 멤버별 소속 팀의 리스트를 싹 뽑아내는 메소드
    public ArrayList<team> getTeamByMember(int mid) {
        ArrayList<team> getTeams = null;

        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "ㅋselect team.tid from team,belong_team where team.tid = belong_team and belong_team.mid =?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, mid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                int masterId = rs.getInt("masterId");
                team a = new team(tid, tname, masterId);

                getTeams.add(a);

            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return getTeams;

    }
//본인은 속하지 않는 모집중인 팀을 뽑는 메소드
   public  ArrayList<team> getRecuritingTeam(int mid) {
        ArrayList<team> getTeams = null;
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "select team.tid from team,belong_team where team.tid = belong_team.tid and belong_team.mid != ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, mid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                int masterId = rs.getInt("masterId");
                team a = new team(tid, tname, masterId);

                getTeams.add(a);

            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return getTeams;
    }
    //본인이 운영자인 팀을 뽑는 메소드
    public ArrayList<team> getOperatingTeam(int mid){
        ArrayList<team> getTeams = null;
        String url = "jdbc:mysql://localhost:3306/project";
        String sql = "select tid from team where team.masterId = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, mid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tname = rs.getString("tname");
                int masterId = rs.getInt("masterId");
                team a = new team(tid, tname, masterId);

                getTeams.add(a);

            }

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return getTeams;
    }


}
