function Component1(props){
    return <h4>한줄로 입력시() 생략가능</h4>
}// fend

//(3)
function Component2(props){
    return(
        <div>
            <h4>두줄로 입력시( ) 필수로 감싸기</h4>
        </div>
    )
}// f end

//(4)
function Component3(props){
    return(
        <>
            <h4>div 대신에 이름없는 마크업 사용 가능</h4>
        </>
    )
}

//(5)
function Component4(props){
    const name = '유재석'
    const age = 40;
    const obj ={name:'강호동' , age:50}

    return(
        <>
            <h4>{name}님의 나이 : {age}</h4>
            <h4>{obj.name}님의 나이 :{obj.age}</h4>
        
        </>
    )
}// f end

//(6)
function Component5(props){
    const loginState = true; //로그인상태
    //jsx문법{ }표현식에서는 if,for,function,const,let 불가능
    return(
        <>
            <h4>{loginState==true?'로그인중':'비로그인중'} </h4>
            <h4>{loginState&&<p>로그인 상태일때만 보이는 메세지</p>}</h4>
        </>

    )
}
//(7)
function Component6(props){
    const items =['사과','딸기','바나나']
    //jsx 문법의 목록(li,option등등) 마크업들에는 key 속성 필요로 함.
    //JSX 문법에서는 forEach 보다 map 함수를 씀ㅋㅋ
    return (
        <>
            <ul>
                {
                    items.map(item,index =>{
                        <li key={index}>{item}</li>
                     })
                }

            </ul>
        </>
    )
}

//(8)
function Component7(props){
    //style 속성에 style ='color:blue'[x]
    //style 속성에 style ={{css객체}} [o]
    //주의 : css 카멜표기법 ,JS 속성명은 - 하이픈 사용하지 못하므로 
    const cssObj ={color:'red' , fontSize:30}
    return(
    <>
        <h4 style={{color:'blue'}}>인라인 형식의 css 넣기</h4>
        <h4 style={{cssObj}}>인라인 형식의 객체 CSS넣기</h4>
        <h4 className="myClas">CSS파일 내 선택자 이용한 CSS 넣기</h4>
    </>
    )
}