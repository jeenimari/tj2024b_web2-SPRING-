let a = 0

export default function Example1(props){
    
    let b =0;

    ++a;
    ++b;
    
    //증가함수
    const 증가함수 = ( )=>{
        ++a;
        ++b;
        //+ innerHtml 안해서 반응없는거
        console.log(a,b)
    }
    
    
    return(<>
        <h3>{++a}</h3>{/*2*/}
        <h3>{++b}</h3>{/*2*/}
        <button type="button" onClick={증가함수}>증가함수</button>
    </>)
}