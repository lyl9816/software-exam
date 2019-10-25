package software.exam.db.model.dto;

import lombok.Data;
import software.exam.db.domain.Choices;

import java.util.List;

@Data
public class OnlineDto {

    private int id;
    //问题id
    private int qid;
    //课程id
    private int cid;
    //题目
    private String title;
    //答案
    private List<Choices> choices;
    //所属课程
    private String name;
    //解析
    private String detail;



}
