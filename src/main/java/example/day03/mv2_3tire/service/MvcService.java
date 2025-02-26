package example.day03.mv2_3tire.service;

import example.day03.mv2_3tire.model.repository.MvcRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Mvc 패턴의 서비스임을 알리는 어노테이션
public class MvcService {

        //순환참조 조심

    //controller -> service -> repository 구조

    //[2](디폴트)생성자에 빈 주입
final MvcRepsitory mvcRespsitory;

@Autowired
    public MvcService(MvcRepsitory mvcRepsitory){
    this.mvcRespsitory = mvcRepsitory;

}
}
