import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function BookCreate(props) {
  // form에서 입력받은 데이터들을 저장하는 상태변수, 초기값 설정
  const [bookForm, setBookForm] = useState({
    title: '',
    author: '',
    intruduce: '',
    pw: ''
  });

  // 입력 이벤트 만들기
  const onValueChange = (e) => {
    setBookForm({ ...bookForm, [e.target.name]: e.target.value });
  };

  // 도서 추천 등록 버튼 클릭 시 처리
  const navigate = useNavigate();
  const onCreate = async () => {
    try {
      const response = await axios.post('http://localhost:8080/day09/books', bookForm);
      if (response.data === true) {
        alert('도서 추천이 등록되었습니다.');
        navigate('/books');
      } else {
        alert('도서 추천 등록에 실패했습니다.');
      }
    } catch (error) {
      console.error('도서 추천 등록 중 오류 발생:', error);
      alert('서버 통신 중 오류가 발생했습니다.');
    }
  };

  return (
    <div>
      <h2>새로운 도서 추천</h2>
      <form>
        <div>
          <label>책 제목: </label>
          <input
            name="title"
            value={bookForm.title}
            onChange={onValueChange}
            required
          />
        </div>
        
        <div>
          <label>저자: </label>
          <input
            name="author"
            value={bookForm.author}
            onChange={onValueChange}
            required
          />
        </div>
        
        <div>
          <label>도서 소개: </label>
          <textarea
            name="intruduce"
            value={bookForm.intruduce}
            onChange={onValueChange}
            rows="5"
            required
          ></textarea>
        </div>
        
        <div>
          <label>비밀번호 (추후 수정/삭제 시 필요): </label>
          <input
            type="password"
            name="pw"
            value={bookForm.pw}
            onChange={onValueChange}
            required
          />
        </div>
        
        <button type="button" onClick={onCreate}>도서 추천 등록</button>
      </form>
    </div>
  );
}