console.log("index.js open")

//[4]개별 삭제 함수
const onDelete = async ( sno ) =>{
    //(1)삭제할 번호 sno
    //(2)axios 통신
    const response = await axios.delete(`/day04/student?sno=${sno}`)
    if(response.data ==1){onFindAll();} //만약에 응답 내용이 1이면 삭제 수정 -> 전체조회함수 수정 실행

}


//[3]개별 수정 함수
const onUpdate =async ( sno ) =>{
    //(1)수정할 값 받기
    const name =prompt("새로운 이름")
    const kor = prompt("새로운 국어점수")
    const math =prompt("새로운 수학점수")
    //(2)객체화
    const obj ={sno,name,kor,math};

    //(3)axios 통신
    await axios.put('/day04/student',obj)
    if(response.data == 1){onFindAll();} //만약에 응답 내용이 1이면 수정 성공 -> 전체 조회 함수 실행
}


//[2]전체 조회 함수
const onFindAll = async( ) =>{

 try{
  const response = await axios.get('/day04/student')
  console.log(response.data);
  const tbody = document.querySelector('tbody')
  let html = ``
  response.data.forEach(student=>{
    html +=`<tr>
            <td>${student.name}</td>
            <td>${student.kor}</td>
            <td>${student.math}</td>
            <td><button onclick="onUpdate(${student.sno})">수정</button></td>
            <td><button onclick="onDelete(${student.sno})">삭제</button></td>
            </tr>`
  })
  tbody.innerHTML = html;
  }catch(e){console.log(e);}

 }// fend

onFindAll();



//[1]등록함수

const onSave= ()=>{

    //(1)
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;

    //(*) 객체{ } 선언할때 대입할 변수명이 객체의 필드명 동일하면 생략가능
    const obj ={ name ,kor , math};
    console.log(obj);


    //(*)fetch 대신에 axios 활요한 비동기화 통신 vs 동기화 통신
    axios.post('/day04/student',obj)
    .then(response=>{console.log(response);onFindAll();})
    .catch(e=>{console.log(e);})









//    const obj = {name : name ,kor : kor ,math: math} 이게원래 정석
    //(*) 1.Fetch(JS내장함수) vs 2.Axios(기본값JSON) vs 3.$.ajax(JQUERY)

//        axios.post('/day04/student')
//            .then(response=>{console.log(response);})
//            .catch(e=>{console.log(e);})

    //(3)
//    console.log('axios 실행 전')   //첫번째 콘솔
//    axios.post('/day04/student',obj)
//    .then(response=>{console.log(response.data);}) // 2.두번째 콘솔
//    .catch(e=>{console.log(e);})
//
//    console.log('axios 실행후') // 3.세번째 콘솔
    //첫번째 콘솔 -->세번째 콘솔 ---->두번재 콘솔 : 비동기 통신(JS 는 axios요청 보낸 후에 응답을 기다리지않고 다음 코드 실행)
    //예시]카페에서 '커피'하나 주문자와 '커피/빵/파스타' 주문 사람 중 누가 먼저 응답올까?
    //(비동기) : 먼저 처리/응답된 순서대로 처리

//(4) 동기화 방법(필요에따라) vs 비동기 방법 = 기본값
        //동기화 : await 함수명()
//     console.log('axios 실행 전')
//     const response = axios.post('/day04/student',obj)
//     console.log(response.data);//두번째 콘솔
//     console.log('axios 실행후') // 3.세번째 콘솔


    /*
    option = {
        method : 'POST'
        headers : {'Content-Type ' : 'application/json'},
        body : Json.stringify(obj)
        }
        fetch('/day04/stundent , option')
        .then(r=>r.json)
        .then(data =>{console.log(data);})
        .catch(e=>{console.log(e);})
    */

}//fend