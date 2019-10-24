package software.exam.db.model.dto;

import software.exam.db.domain.Choices;

import java.util.List;

public class RealChoicesDto {
    private Integer rqid;
    private String title;//题目
    private List<Choices> choices;//选项
    private String detail;//解析

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRqid() {
        return rqid;
    }

    public void setRqid(Integer rqid) {
        this.rqid = rqid;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
}

