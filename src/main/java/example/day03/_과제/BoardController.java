package example.day03._과제;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired private  BoardService boardService;
    //1.글쓰기 요청자료  타이틀 , 컨텐츠
    @PostMapping("/day03/task/board")
    public boolean wirte(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.wirte");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.write(boardDto);
        return true;
    }

    //2.전체 글 조회 요청자료
    @GetMapping("/day03/task/board")
    public List<BoardDto>findAll(){
        System.out.println("BoardController.findAll");
        List<BoardDto>result = boardService.findAll();
        return result;
    }
    //3.개별 글 조회
    @GetMapping("/day03/task/board/view")
    public BoardDto find(@RequestParam("bno")int bno){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        //컨트롤러에서 서비스에게 전달하고 응답
        BoardDto result = boardService.find(bno);
        return result;
    }
    //4.개별 글 수정
    @PutMapping("/day03/task/board")
    public int update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);

        int result = boardService.update(boardDto);
        return result;
    }

    //5.개별 글 삭제
    @DeleteMapping("/day03/task/board")
    public int delete(@RequestParam("bno")int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        int result = boardService.delete(bno);
        return result;
    }
}// class end
