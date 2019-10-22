package software.exam.db.model.dto;

import lombok.Data;
import software.exam.db.domain.Analyze;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Questions;

import java.util.List;

@Data
public class QuestionsDto {
    private Integer id;

    private Integer qid;

    private String detail;

    private Integer rqid;

    private String title;

    private Integer lid;

    private Integer cid;
   private  List<Choices> choices;
}
