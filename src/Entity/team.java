package Entity;

public class team {
    int tid;
    String tname;
    int masterId;

    public team(int tid, String name, int masterId) {
        this.tid = tid;
        this.tname = name;
        this.masterId = masterId;
    }


    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTid() {
        return tid;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
