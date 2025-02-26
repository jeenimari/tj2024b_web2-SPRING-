package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Repository
public class BoardDao {

   // @Autowired BoardDao boardDao;
//게시물 리스트 선언

    private ArrayList<BoardDto> boards = new ArrayList<>();
    private int auto_increment = 1; // bno 자동번호 역할

    //게시물 쓰기 처리 함수
    public boolean create(BoardDto boardDto){
        boardDto.setBno( auto_increment ); // 3. boardDto의 bno를 넣어준다.
        boards.add( boardDto ); // 4. 리스트에 boardDto를 넣어준다.
        auto_increment++; // 5. auto_increment 증가한다.
        return true; // 6. 리턴한다.
    }

    //게시물 전체 조회 함수
    public ArrayList<BoardDto>readAll(){
        return boards;
    }
    //게시물 수정 처리 함수
    public boolean update( BoardDto boardDto){
        for( int index = 0 ; index <= boards.size()-1 ; index++ ){
            BoardDto boardDto2 = boards.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                boards.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end


    // 게시물 삭제 함수
    public boolean delete(int bno){
        for( int index = 0 ; index <= boards.size()-1 ; index++  ){
            BoardDto boardDto2 = boards.get(index);
            if( boardDto2.getBno() == bno ){
                boards.remove( index );
                return true;
            }
        }
        return false;
    }


    public BoardDto boardview(int bno){
        for( int index = 0 ; index <= boards.size()-1 ; index++ ){
            BoardDto boardDto = boards.get(index);
            if( boardDto.getBno() == bno ){ return boardDto; } // 찾았으면 찾은 DTO 반환
        }
        return null; // 없으면
    }










}
