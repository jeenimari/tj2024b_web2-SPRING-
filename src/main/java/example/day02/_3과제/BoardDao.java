package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class BoardDao {

   // @Autowired BoardDao boardDao;
//게시물 리스트 선언

    private ArrayList<BoardDto> boards = new ArrayList<>();

    //게시물 쓰기 처리 함수
    public boolean create(BoardDto boardDto){
        return boards.add(boardDto);

    }

    //게시물 전체 조회 함수
    public ArrayList<BoardDto>readAll(){
        return boards;
    }
    //게시물 수정 처리 함수
    public boolean update(int bno, BoardDto boardDto){
        if(bno >= boards.size() || bno < 0){
            return false;
        }
        boards.set(bno, boardDto);
        return true;
    } // f end


    // 게시물 삭제 함수
    public boolean delete(int bno){
        if(bno >= boards.size() || bno < 0){
            return false;
        }
        boards.remove(bno);
        return true;
    }










}
