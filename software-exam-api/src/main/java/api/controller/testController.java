package api.controller;

import api.utils.ResponseUtil;
import software.exam.db.domain.Board;
import software.exam.db.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {

    @Autowired
    private BoardMapper boardMapper;

    @GetMapping("/home")
    public Object test() {

        Map<String, Object> result = new HashMap<>();
        Board board = null;
        board=boardMapper.selectByPrimaryKey(1);
        result.put("tte", "111111111111111111");
        result.put("board", board);
        return ResponseUtil.ok(result);
    }
}
