package example.day03.mvc2_mybatis.service;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.model.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//서비스가 DAO의 역할을함
@Service
public class MyService {

    @Autowired private MyMapper myMapper;

    //[1]등록 로직
    public int save(MyDto myDto){
        System.out.println("MyService.save");
        System.out.println("myDto = " + myDto);
        int result =  myMapper.save(myDto);
        return result;

    }

    //[2]전체조회 로직
    public List<MyDto>findAll(){
        System.out.println("MyService.findAll");

        return myMapper.findall();
    }
    //[3]개별조회 로직
    public MyDto find(int id){
        System.out.println("MyService.find");
        System.out.println("id = " + id);
        MyDto result = myMapper.find(id);
        return result;
    }
    //[4]개별 수정 로직
    public int update(MyDto myDto){
        System.out.println("MyService.update");
        System.out.println("myDto = " + myDto);
        int result = myMapper.update(myDto);
        return result;
    }
    //[5] 개별삭제 로직
    public int delete(int id){
        System.out.println("MyService.delete");
        System.out.println("id = " + id);
        int result = myMapper.delete(id);
        return result;
    }
}// class end
