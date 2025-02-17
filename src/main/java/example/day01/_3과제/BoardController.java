package example.day01._3과제;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @PostMapping("/day01/task/board")
    @ResponseBody
    public boolean boardWrite() {

       return false;



    }

    @GetMapping("/day01/task/board")
    @ResponseBody
    public List<Map<String, Object>> boardList() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("bno", i + 1);
            map.put("title", "제목 " + (i + 1));
            list.add(map);
        }

        return list;
    }


    @GetMapping("/day01/task/board/view")
    @ResponseBody
    public Map<String, Object> boardView() {
        Map<String, Object> map = new HashMap<>();
        map.put("bno", "1");
        map.put("Title", "테스트입니다");


        return map;
    }

    @PutMapping("/day01/task/board")
    @ResponseBody
    public boolean boardUpdate() {

        return true;
    }

    @DeleteMapping("/day01/task/board")
    @ResponseBody
    public int boardDelete() {
        return 3;
    }
}



