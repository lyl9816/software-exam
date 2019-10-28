package core.service;

import software.exam.db.domain.Board;

import java.util.List;

public interface BoardService {
    //获取通告
    public List<Board> selectTips();
    //获取注意事项
    public List<Board> selectContents();
}
