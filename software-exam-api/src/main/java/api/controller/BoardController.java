package api.controller;

import api.utils.ResponseUtil;
import core.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BoardController {
    @Autowired
    private BoardServiceImpl boardService;

    @GetMapping("/getBoardTip")
    public Object getBoardTip(){
        List<Board> tips = boardService.selectTips();
        Map<String,Object> map=new HashMap<>();
        map.put("tips",tips);
        return ResponseUtil.ok(map);
    }
    @GetMapping("/getBoardContents")
    public Object getBoardContents(){
        List<Board> contents=boardService.selectContents();
        Map<String,Object> map=new HashMap<>();
        map.put("contents",contents);
        return ResponseUtil.ok(map);

    }

}
