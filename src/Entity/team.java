package Entity;

public class team {
    int tid;
    String name;
    int masterId;

    public team(int tid, String name, int masterId) {
        this.tid = tid;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
