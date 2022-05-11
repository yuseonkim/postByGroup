package Entity;

import java.sql.Date;

public class post {
    int pid;
    String writerId;
    String title;
    String content;
    String file;

    public post(int pid, String writerId, String title, String content, String file, Date date) {
        this.pid = pid;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.file = file;
        this.date = date;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Date date;


}
