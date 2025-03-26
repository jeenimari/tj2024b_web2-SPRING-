package example.day12._과제;

//List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");
//
//// 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//// 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//// 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//
//// 4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
//
//// 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//// 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//// 7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;




//// //8.//메소드 레퍼런스 사용함  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
public class Example4 {



    public static void main(String[] args) {

        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

        과일들.forEach(과일->{
            System.out.println(과일+"문제1번");
        });

        List<String> result1= 과일들.stream()
                .map(과일->과일)
                .collect(Collectors.toList());
        System.out.println(result1+"문제 2번");


        과일들.stream()
                .filter(과일->과일.equals("바나나")||과일.equals("대추"))
                .forEach(x-> System.out.println(x+"문제3번"));

        과일들.stream()
                .sorted()
                .forEach(x-> System.out.println(x+"문제4번"));


        과일들.forEach(System.out::println);

        과일들.stream()
                .map(String::toString )
                .forEach(System.out::println);

        List<String> 찾을과일 = List.of("바나나", "대추");

        과일들.stream()
                .filter(찾을과일::contains)
                .forEach(System.out::println);







    }// m end


}//c end
