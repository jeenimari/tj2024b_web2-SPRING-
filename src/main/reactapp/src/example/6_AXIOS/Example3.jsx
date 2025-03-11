import { useEffect, useState } from "react";
import axios from "axios";

/* 전화번호부 만들기
조건1: '이름' '전화번호' 입력받아 배열에 저장
조건2: 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul로 모두 출력
조건3: usestate 사용 */

export default function Example3() {
    let [inputName, setInputName] = useState("");
    let [inputPhone, setInputPhone] = useState("");
    
    let [AllInfo, setAllInfo] = useState([]);
    
    //컴포넌트 마운트 시 서버에서 모든 연락처 데이터 로드
    useEffect(() => {
        fetchContacts();
    }, []);
    
    //서버에서 모든 연락처 가져오기
    const fetchContacts = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/contacts");
            setAllInfo(response.data);
        } catch (error) {
            console.error("연락처가져 오는중에 오류발생:", error);
        }
    };
    
    //이름입력
    const Name = (event) => {
        setInputName(event.target.value);
    };
    
    //전화번호 처리
    const Phone = (event) => {
        setInputPhone(event.target.value);
    };
    
    //연락처 추가 함수
    const addContact = async () => {
        if (inputName && inputPhone) {
            try {
                const newContact = {
                    name: inputName,
                    phone: inputPhone
                };
                await axios.post("http://localhost:8080/api/contacts", newContact);
                
                //성공 후 입력 필드 초기화
                setInputName("");
                setInputPhone("");
                
                //목록 새로고침
                fetchContacts();
            } catch (error) {
                console.error("연락처 저장 중 오류 발생:", error);
            }
        } else {
            alert("이름과 전화번호 모두 입력");
        }
    };
    
    return (
        <>
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
                    {AllInfo.map((contact, index) => (
                        <tr key={index}>
                            <td>{contact.name}</td>
                            <td>{contact.phone}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
}