package example.day04task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardMapper boardMapper;

    //1.글쓰기

    public boolean write(BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println("board = " + boardDto);
        boolean result = boardMapper.write(boardDto);
        return result;


    }// fend


    //2.전체 글 조회


    public List<BoardDto> AllContents(){
        System.out.println("BoardController.AllContents");

        return boardMapper.AllContents();
    }

    //3.개별 글 조회

    public BoardDto view(int bno){
        System.out.println("BoardController.view");
        System.out.println("boardDto = " + bno);

        BoardDto result = boardMapper.view(bno);
        return result;

    }

    //4.개별 글 수정

    public boolean editpost(BoardDto boardDto){
        System.out.println("BoardController.editpost");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.editPost(boardDto);
        return result;

    }
    //5.개별 글 삭제

    public boolean editDelete(int bno){
        System.out.println("BoardController.editDelete");

        boolean result = boardMapper.deletePost(bno);
        return result;
    }

}
