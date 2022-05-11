package Entity;

public class member {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public member(String id, String pw, int mid, String name, int grade) {
        this.id = id;
        this.pw = pw;
        this.mid = mid;
        this.name = name;
        this.grade = grade;
    }

    String id;
    String pw;

    int mid;
    String name;
    int grade;


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
