package core.service.impl;

import core.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.Board;
import software.exam.db.domain.BoardExample;
import software.exam.db.mapper.BoardMapper;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> selectTips() {
        BoardExample be=new BoardExample();
        BoardExample.Criteria criteria=be.createCriteria();
        criteria.andTipNotEqualTo("0");
        return boardMapper.selectByExample(be);
    }

    @Override
    public List<Board> selectContents() {
        BoardExample be=new BoardExample();
        BoardExample.Criteria criteria=be.createCriteria();
        criteria.andContentIsNotNull();
        return boardMapper.selectByExample(be);
    }
}
