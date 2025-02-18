package example.day02._3과제;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/day02/task1/board")

public class RestController {
    // 1.글쓰기
    @PostMapping("/day02/task1/board")
    @ResponseBody
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("제목 : " + boardDto.getTitle());
        System.out.println("내용 : " + boardDto.getContent());
        return true;
    }

    //2. 전체 글 조회
    @GetMapping("/day02/task1/board")
    @ResponseBody
    public List<Map<String,Object>>boardList (){
        List<Map<String,Object>> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            Map<String,Object>map = new HashMap<>();
            map.put("bno",i+1);
            map.put("title","제목"+(i+1));
            map.put("content","내용"+(i+1));
            list.add(map);
        }
        return list;
    }

    //3.개별 글 조회
    @GetMapping("/day02/task1/board/view")
    @ResponseBody
    public Map<String,Object>boardview(@RequestParam int bno){
        Map<String,Object>map = new HashMap<>();
        map.put("bno",bno);
        map.put("title","타이틀입니다"+bno);
        map.put("content","내용입니다"+bno);
        return map;
    }

    //4.개별 글 수정
    @PutMapping("day02/task1/board")
    @ResponseBody
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        System.out.println("bno : " + boardDto.getBno());
        System.out.println("제목 : " + boardDto.getTitle());
        System.out.println("내용 : " + boardDto.getContent());

        return true;
    }

    //5.개별 글 삭제
    @DeleteMapping("/day02/task1/board")
    @ResponseBody
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("삭제할 게시물 번호 : "+ bno);
        return true;
    }

}// class end
