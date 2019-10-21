package db.domain;

public class Analyze {
    private Integer id;

    private Integer qid;

    private String detail;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getRqid() {
        return rqid;
    }

    public void setRqid(Integer rqid) {
        this.rqid = rqid;
    }
}