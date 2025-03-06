import{use, useState}from "react"

let a = 0; //전역변수

export default function Example2(props){
    a++; // 전역변수 1증가
    let b = 0; //지역변수
    b++; //지역변수 1증가

    console.log(`전역변수a :${a}`)
    console.log(`지역변수 b:${b}`)

    //(1) 전역변수/지역변수 증가하는 함수
    const 증가함수1 = ( )=>{ 
        a++; b++;
        console.log(a,b);

    }
    //(3)state 변수 사용 , 훅종류 중에 핵심함수 , useState
    let c = useState(0); // state 상태변수 선언
    console.log(c); //[0] 변수값 ,[1] :변수값 수정할 수 있는 함수 제공 =>2개를 갖는 배열로 반환
    console.log(c[0]);
    console.log(c[1]);

    const 증가함수2 = ( )=>{
        c[1](c[0]++); //컴포넌트/함수 가 재실행==>return 실행됨
        //전역변수는 컴포넌트 재실행에 관계가 없으므로 누적
        //지역변수는 컴포넌트 재실행(렌더링)에 관계가 있으므로
        // state 변수는 지역/전역변수 아닌 개념이 아닌 리액트가 별도로 상태(값)저장/관리 해줌(IOC/dr)의존성


    }
    // (4)state 일반적인 사용법 , 구조분해 ,const{변수명,set 변수명}=useState(초기값) ;
    let [count,setCount] = useState(0);

    const 증가함수3 = ( )=>{ 
        console.log(count)
        // count = count + 1; const 불가능/const 상수
        console.log(count)
      //렌더링 제공함수 , setxxx새로운값
      setCount(count+1); //count가 const가 const 일때 count+1가능,count++(count=count+1)불가능 
    }
    //컴포넌트(함수) : 한번 return 된 jsx 문법의 결과(HTML)불변성임.
    return(<>
            <div>
                <p>일반변수: {a},{b}</p>
                <button onClick={증가함수1}>증가함수1</button>
            
            </div>
            <div>
                <p>state 변수:{c}</p>
                <button onClick={증가함수2}>증가함수2</button>


            </div>
            <div>
                <p>state 변수2:{count}</p>
                <button onClick={증가함수3}>증가함수3</button>
            </div>
        
        </>)
}