package example.day12._람다식;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Calculator{
    int plus(int x , int y);
}

public class Example1 {

    public static int plus(int x , int y){
        return x + y;
    }

    public static void main(String[] args) {
        //일반 메소드 호출
        int result = plus(3,5);
        System.out.println(result);

        //2.추상메소드 호출 , 구현이 필요함 (1)implements (2) 익명객체
//        Calculator calc = new Calculator(); : 인터페이스는 객체 생성을 못함
        //-> 이름 없는 객체로 추상화를 구현한다. ->익명 객체
        Calculator calc = new Calculator() {
            @Override
            public int plus(int x , int y){
                return x+y;
            }

        };
        int result2 = calc.plus(3,5);
        System.out.println(result2);

        //3.람다 표현식 : JS(화살표함수 비슷)
        Calculator calc3 = (x,y)-> x + y;
        int result3 = calc.plus(3,5);
        System.out.println(result3);


        //4.람다표현식을 제공하는 타입 , Function<매개변수타입 ,리턴값 타입>, .apply(인자값)
        Function<Integer , Integer> function = x-> x*2;
        System.out.println(function.apply(3));
        System.out.println(function.apply(7));

        Predicate< Integer >predicate = x->x % 2 == 0;               //Predicate < 매개변수타입 >,실행결과 true or false 반환
        System.out.println(predicate.test(3));

        //Supplier<리턴값 타입>, get()
        Supplier<Double >supplier = ( )->Math.random();
        System.out.println(supplier.get()); // 인자값 x, 난수값 반환

        //Consumer<매개변수타입>
        Consumer<String>consumer = str-> System.out.println(str);
        consumer.accept("안녕하세요.");

        //5.주로 컬렉션 프레임워크와 같이 사용된다.
        List<String>과일목록 = new ArrayList<>();
        과일목록.add("사과");과일목록.add("바나나"); 과일목록.add("수박");
//        리스트명.forEach((매개변수)->{실행코드});
        과일목록.forEach((과일)->{
            System.out.println("과일명:" + 과일);
        });

    }// m end

}
