import{use, useState}from "react"
/*
전화번호부 만들기
조건1: '이름' '전화번호' 입력받아 배열에 저장
조건2: 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul로 모두 출력
조건3: usestate 사용
*/
export default function task2(){


    let [inputName, setInputName] = useState("")
    let [inputPhone,SetInputPhone] = useState("")
    
    let [AllInfo,setAllInfo] =useState([])

    //이름입력
    const Name=(event)=>{
        setInputName(event.target.value)
    }
    //전화번호 처리
    const Phone=(event)=>{
        SetInputPhone(event.target.value)
    }

    //연락처 추가 함수
    const addContact = ()=>{
        if(inputName&&inputPhone){
            const newAllInfo = {
                name : inputName,
                phone : inputPhone
            }
            setAllInfo([...AllInfo,newAllInfo])
            setInputName("")
            SetInputPhone("")
        }
    }

    return(<>

<h1>전화번호부</h1>
      
      <div>
        <input 
          placeholder="이름"
          value={inputName}
          onChange={Name}
        />
        <input 
          placeholder="전화번호"
          value={inputPhone}
          onChange={Phone}
        />
        <button onClick={addContact}>저장</button>
      </div>
      
      <h2>연락처 목록</h2>
      <table border="1">
        <thead>
          <tr>
            <th>이름</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody>
            {AllInfo.map((contact, index) => ( //for문과 개념 비슷
                 <tr key={index}>
                <td>{contact.name}</td>
                <td>{contact.phone}</td>
            </tr>
    ))}
        </tbody>
      </table>
    
    
    
    </>)

}

