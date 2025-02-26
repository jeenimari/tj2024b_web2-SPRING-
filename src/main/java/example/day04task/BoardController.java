package example.day04task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired private BoardService boardService;

    //1.글쓰기
    @PostMapping("/day04/task/board")
    public boolean write(@RequestBody BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println("board = " + boardDto);
        boolean result = boardService.write(boardDto);
        return result;


    }// fend


    //2.전체 글 조회

    @GetMapping("/day04/task/board")
    public List<BoardDto>AllContents(){
        System.out.println("BoardController.AllContents");
        System.out.println();
        return boardService.AllContents();
    }

    //3.개별 글 조회
    @GetMapping("/day04/task/board/view")
    public BoardDto view(@RequestParam int bno){
        System.out.println("BoardController.view");
        System.out.println("boardDto = " + bno);

        BoardDto result = boardService.view(bno);
        return result;

    }

    //4.개별 글 수정
    @PutMapping("/day04/task/board")
    public boolean editpost(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.editpost");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.editpost(boardDto);
        return result;

    }
    //5.개별 글 삭제
    @DeleteMapping("/day04/task/board")
    public boolean editDelete(@RequestParam int bno){
        System.out.println("BoardController.editDelete");
        System.out.println("boardDto = " +bno);
        boolean result = boardService.editDelete(bno);
        return result;
    }
}// class end
