package Service.main;

import Entity.team;

import java.sql.*;
import java.util.ArrayList;

public class mainService {

    //특정 멤버별 소속 팀의 리스트를 싹 뽑아내는 메소드
    public ArrayList<team> getTeamByMember(int mid) {
        ArrayList<team> getTeams = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from (select @rn:=@rn+1 as rn,team.* from team,belong_team,(select @rn:=0)r where team.tid=belong_team.tid and belong_team.mid=?)a;";
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
    public ArrayList<team> getRecuritingTeam(int mid) {
        ArrayList<team> getTeams = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from (select @rn:=@rn+1 as rn,team.* from team,belong_team,(select @rn:=0)r where team.tid=belong_team.tid and belong_team.mid!=? and team.isRt = 1)a;";
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
    public ArrayList<team> getOperatingTeam(int mid) {
        ArrayList<team> getTeams = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from (select @rn:=@rn+1 as rn,team.* from team,(select @rn:=0)r where team.masterId = ?)a;";
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

    public int registerService(int tid, int mid) {//팀 가입 요청 메소드
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "insert into joinRequestMember(tid,mid) values (?,?)";
        int result = -1; //오류발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, tid);
            st.setInt(2, mid);
            result = st.executeUpdate();


            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int checkAlreadyOrder(int tid, int mid) {//이미 신청한 팀에 신청을 하는지 체크
        int result = 0;
        String url = "jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf-8";
        String sql = "select * from joinRequestMember where mid=?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "0143");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, mid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt("tid") == tid)
                    result = 1; //중복 발생
                break;
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

