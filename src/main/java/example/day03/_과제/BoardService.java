package example.day03._과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardMapper boardMapper;

    //[1]글쓰기 등록 로직

    public boolean write(BoardDto boardDto){
        System.out.println("BoardService.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper.write(boardDto);
        return result;
    }

    //[2]전체 글 조회
    public List<BoardDto>findAll(){
        System.out.println("BoardService.findAll");
        return boardMapper.findAll();
    }
    //[3]개별 글 조회 로직
    public BoardDto find(int bno){
        System.out.println("BoardService.find");
        System.out.println("bno = " + bno);
        BoardDto result = boardMapper.find(bno);
        return result;
    }
    //[4]개별 글 수정
    public int update(BoardDto boardDto){
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);
        int result = boardMapper.update(boardDto);
        return result;
    }
    //[5]개별삭제 로직
    public int delete(int bno){
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);
        int result = boardMapper.delete(bno);
        return result;
    }
}
