package example.day12._스트림;

import java.util.List;
import java.util.stream.Collectors;

public class Example2 {

    public static void main(String[] args) {

        //*임의의 리스트 List.of(초기값1,
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
            //< > : 제네릭타입 :  클래스 또는 인터페이스 타입 내 전달하는 타입 , 기본타입이 불가능
                //---> int(기본타입) vs Integer(참조타입/래퍼클래스) : 기본타입 8개를 클래스로 사용할때
            //List(인터페이스/추상) vs ArrayList/Vector/LinkedList(클래스/구현)


        //1.컬렉션 프레임워크 는 스트림 제공한다 . .stream()
        numbers.stream() // 스트림 생성
                .forEach(x-> System.out.println(x));

        //2. .stream().map() vs , JS : .map

        List<Integer>result2 = numbers.stream().map(x->x*2).collect(Collectors.toList()); //map
        System.out.println(result2);

        //3.
        numbers.stream()    // 1.numbers 에 데이터하나씩 이동하는 데이터 통로생성
                .map(x->x*2) //2.데이터 통로를 이동하면서 데이터를 중간연산
                .forEach(x-> System.out.println(x)); //3.데이터 통로의 끝에 데이터 결과를 출력한다.

        //4.
        numbers.stream()
                .filter(x->x%2==0)//짝수만 필터
                .forEach(x-> System.out.println(x));

        //5.
        numbers.stream().sorted().forEach(x-> System.out.println(x));

    }
}
