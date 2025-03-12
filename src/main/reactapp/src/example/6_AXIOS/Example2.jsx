import { useEffect, useState } from "react"
import axios from 'axios';
export default function Example2(props){
    //[1]입력받은 데이터를 저장하는 폼 state 변수 
    const [formData,setFormData] =useState({writer:'',content:' ',pwd:''})
    //[2]입력받은 데이터를 렌더링 하는 이벤트함수.
    const formDataChange = (e)=>{
        console.log(e.target); //이벤트를 발생한 html dom(마크업/태그)
        console.log(e.target.name) //이벤트를 발생한 html dom의 name속성값  반환
        console.log(e.target.value); //이벤트를 발생한 html dom의 value 속성 값 반환 
        //스프레드 연산자 이용한 state 변수 변경
        setFormData({...formData,[e.target.name]:e.target.value});
    }
    
    //[3]현재 state 변수를 스프링 서버에게 보내기
    const onPost = async(e)=>{
        try{
            const response = await axios.post('http://192.168.40.11:8080/day07/react',formData); // state 변수를 axios로 보내기
            if(response.data==true){
                alert('등록성공');
                setFormData({writer:'',content:'',pwd:''}); //state 초기화
                onfindAll();// 등록성공하면 자동 렌더링
            }else{
                alert('등록실패');
            }

        }catch(error){console.log(error)}
    }

    //[4]서버에 저장된 방문록 정보(작성자/내용/비밀번호 여러개)요청함
    useEffect(()=>{onfindAll()},[]); //1.컴포넌트 마운트(생성)될때 최초 1번 실행함수 

    const [boards,setBoards] =useState([]); //여러개의 방문록 가지는 state변수
     
    const onfindAll = async(e)=>{
        try{
            const response = await axios.get('http://192.168.40.11:8080/day07/react')
            setBoards(response.data); //서버로부터 받은 정보를 state변수에 저장

        }catch(error){console.log(error)}
    }
    
    
    return(<>
        <div>
            <h4>입력 폼</h4>
            <form>
                작성자 : <input type="text" value={formData.writer} name="writer" onChange={formDataChange}/><br/>
                방문록 : <input type="text" value={formData.content} name="content" onChange={formDataChange}/><br/>
                비밀번호 :<input type="text" value={formData.pwd} name="pwd" onChange={formDataChange}/><br/>
                <button type="button" onClick={onPost}>등록</button>
            </form>

            <table>
                <thead><tr><th>번호</th><th>작성자</th><th>방문록 내용</th><th>비고</th></tr></thead>
                <tbody>
                    {
                        boards.map((board,index)=>{
                            return(
                                <tr>
                                    <td> { board.num }</td> 
                                    <td> { board.writer}</td> 
                                    <td> { board.content}</td> 
                                    <td> 수정버튼 / 삭제버튼 </td>

                                </tr>
                            )

                        })
                    }




                </tbody>
            </table>
        </div>
    
    </>)
}