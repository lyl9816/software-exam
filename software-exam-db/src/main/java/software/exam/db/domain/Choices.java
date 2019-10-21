package software.exam.db.domain;

public class Choices {
    private Integer id;

    private Integer qid;

    private Integer status;

    private String content;

    private Integer rqid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getRqid() {
        return rqid;
    }

    public void setRqid(Integer rqid) {
        this.rqid = rqid;
    }
}