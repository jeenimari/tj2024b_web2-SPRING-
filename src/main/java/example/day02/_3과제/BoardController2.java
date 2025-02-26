package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/day02/task2/board")
public class BoardController2 {


    private final BoardDao boardDao;

    @Autowired //생성자 주입
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;

    }
    //1.게시물 쓰기
    @PostMapping("")
    @ResponseBody
    public boolean write(@RequestBody BoardDto boardDto) {
        return boardDao.create(boardDto);

    }

    //2.게시물 전체 조회
    @GetMapping("")
    @ResponseBody
    public ArrayList<BoardDto> getAll(){
        return boardDao.readAll();
    }

    //3.게시물 수정
    @PutMapping("")
    @ResponseBody
    public boolean update(@RequestBody BoardDto boardDto) {
        return boardDao.update( boardDto);

    }

    //게시물 삭제
    @DeleteMapping("")
    @ResponseBody
    public boolean delete(@RequestParam int bno) {
        return boardDao.delete(bno);

    }

    @GetMapping("/view")
    @ResponseBody
    public BoardDto boardview(@RequestParam int bno){

        return boardDao.boardview(bno) ;
    }


}
