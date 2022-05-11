package Entity;

import java.sql.Date;

public class comment {
    String content;
    String writerId;
    Date date;

    public comment(String content, String writerId, Date date) {
        this.content = content;
        this.writerId = writerId;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
