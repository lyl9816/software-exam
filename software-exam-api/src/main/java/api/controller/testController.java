package api.controller;

import api.utils.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {

    @GetMapping("/home")
    public Object test() {

        Map<String, Object> result = new HashMap<>();

        result.put("tte", "111111111111111111");
        return ResponseUtil.ok(result);
    }
}
