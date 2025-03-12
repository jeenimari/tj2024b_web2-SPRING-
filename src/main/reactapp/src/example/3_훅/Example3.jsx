import{use, useState}from "react"

export default function Example3(props){
    //일반적인 JS 방법
    const 입력함수 = ( )=>{
        const msg = document.querySelector('#msg').value;
        console.log(msg);
    }

    //(2)리액트 방법 
    const [msg, setMsg] = useState('')  //상태(state)변수 : 변수값에 따른 컴포넌트를 렌더링 제공

    const 입력함수2= (eventObj)=>{
        console.log(eventObj);//
        console.log(eventObj.target); // onchange 이벤트를 발생시킨 마크업(대상)
        console.log(eventObj.target.value); //onChange 이벤트를 발생 시킨 마크업의 value 반환
        //(기존1)documeunt.querySelector('xxx').value
        //(리액트2)e.target.value
        setMsg(eventObj.target.value);

    }

    //(3) 리액트 방법 2
    const [image,setImage] = useState('짱구1.jpg') //이미지를 저장하는 state 변수 선언
    //임의의 이미지 2개이상 다운로드 받아서 리액트 폴더 public 에 저장
    const 변경함수3=( )=>{
        //state변수의 값이 변경되면 자동으로 새로고침/렌더링/컴포넌트 재호출/함수재호출/함수다시리턴->리액트 UI업데이트
        //state 변수의 값을 변경하는 방법 : set변수명(새로운값)
        setImage(image=='짱구1.jpg'? '짱구2jpg' : '짱구1.jpg');
    }
    return(<>
    
        <h1>일반적인 JS 방법</h1>
        <input id="msg"/><br/>
        <button onClick={입력함수}>입력버튼</button>

        <h1>리액트 js 방법</h1>
        <input value={msg}onChange={입력함수2}/><br/>

        <h1>리액트 이미지 변경</h1>
        <img onClick={변경함수3}src={image}/>
       
    </>)
}