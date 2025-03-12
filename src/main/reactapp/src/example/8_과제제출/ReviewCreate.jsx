import { useState } from "react";
import axios from "axios";
import { useNavigate, useLocation } from "react-router-dom";

export default function ReviewCreate(props) {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const bookId = queryParams.get('book_id');
  
  const [reviewForm, setReviewForm] = useState({
    book_id: bookId,
    content: '',
    pw: ''
  });
  
  const onValueChange = (e) => {
    setReviewForm({ ...reviewForm, [e.target.name]: e.target.value });
  };
  
  const navigate = useNavigate();
  const onCreate = async () => {
    try {
      const response = await axios.post('http://localhost:8080/day09/reviews', reviewForm);
      if (response.data === true) {
        alert('리뷰가 등록되었습니다.');
        navigate(`/books/detail?book_id=${bookId}`);
      } else {
        alert('리뷰 등록 실패');
      }
    } catch (error) {
      console.error('리뷰 등록 중 오류 발생:', error);
      alert('서버 통신 중 오류가 발생했습니다.');
    }
  };
  
  return (
    <div>
      <h2>리뷰 작성</h2>
      <form>
        <div>
          <label>리뷰 내용: </label>
          <textarea
            name="content"
            value={reviewForm.content}
            onChange={onValueChange}
            rows="3"
            required
          ></textarea>
        </div>
        
        <div>
          <label>비밀번호: </label>
          <input
            type="password"
            name="pw"
            value={reviewForm.pw}
            onChange={onValueChange}
            required
          />
        </div>
        
        <button type="button" onClick={onCreate}>등록</button>
        <button type="button" onClick={() => navigate(`/books/detail?book_id=${bookId}`)}>취소</button>
      </form>
    </div>
  );
}