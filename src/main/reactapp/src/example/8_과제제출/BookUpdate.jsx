import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useLocation } from "react-router-dom";

export default function BookUpdate(props) {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const bookId = queryParams.get('book_id');
  
  const [bookForm, setBookForm] = useState({
    book_id: bookId,
    title: '',
    author: '',
    intruduce: '',
    pw: ''
  });
  
  useEffect(() => {
    // 도서 정보 불러오기
    const fetchBookDetail = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/day09/books/detail?book_id=${bookId}`);
        setBookForm({
          book_id: response.data.book_id,
          title: response.data.title,
          author: response.data.author,
          intruduce: response.data.intruduce,
          pw: ''
        });
      } catch (error) {
        console.error('도서 정보를 불러오는데 실패했습니다:', error);
      }
    };
    
    fetchBookDetail();
  }, [bookId]);
  
  const onValueChange = (e) => {
    setBookForm({ ...bookForm, [e.target.name]: e.target.value });
  };
  
  const navigate = useNavigate();
  const onUpdate = async () => {
    try {
      const response = await axios.put('http://localhost:8080/day09/books', bookForm);
      if (response.data === true) {
        alert('도서 정보가 수정되었습니다.');
        navigate(`/books/detail?book_id=${bookId}`);
      } else {
        alert('도서 수정 실패: 비밀번호가 일치하지 않거나 시스템 오류');
      }
    } catch (error) {
      console.error('도서 수정 중 오류 발생:', error);
      alert('서버 통신 중 오류가 발생했습니다.');
    }
  };
  
  return (
    <div>
      <h2>도서 정보 수정</h2>
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
          <label>비밀번호: </label>
          <input
            type="password"
            name="pw"
            value={bookForm.pw}
            onChange={onValueChange}
            placeholder="등록 시 입력한 비밀번호"
            required
          />
        </div>
        
        <button type="button" onClick={onUpdate}>수정</button>
      </form>
    </div>
  );
}