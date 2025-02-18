package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardController2 {

    private final BoardDao boardDao;

    @Autowired //생성자 주입
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;

    }
    //1.게시물 쓰기
    public boolean write(BoardDto boardDto) {
        return boardDao.create(boardDto);

    }

    //2.게시물 전체 조회
    public ArrayList<BoardDto> getAll(){
        return boardDao.readAll();
    }

    //3.게시물 수정
    public boolean update(int bno,BoardDto boardDto) {
        return boardDao.update(bno, boardDto);

    }

    //게시물 삭제
    public boolean delete(int bno) {
        return boardDao.delete(bno);

    }


}
