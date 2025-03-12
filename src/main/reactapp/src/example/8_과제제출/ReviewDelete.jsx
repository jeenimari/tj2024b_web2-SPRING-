import { useState } from "react";
import axios from "axios";
import { useNavigate, useLocation } from "react-router-dom";

export default function ReviewDelete(props) {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const reviewId = queryParams.get('review_id');
  
  const [password, setPassword] = useState("");
  
  const onValueChange = (e) => {
    setPassword(e.target.value);
  };
  
  const navigate = useNavigate();
  const onDelete = async () => {
    try {
      const response = await axios.delete(`http://localhost:8080/day09/reviews?review_id=${reviewId}&pw=${password}`);
      if (response.data === true) {
        alert('리뷰가 삭제되었습니다.');
        // 이전 페이지로 돌아가기
        navigate(-1);
      } else {
        alert('리뷰 삭제 실패: 비밀번호가 일치하지 않거나 시스템 오류');
      }
    } catch (error) {
      console.error('리뷰 삭제 중 오류 발생:', error);
      alert('서버 통신 중 오류가 발생했습니다.');
    }
  };
  
  return (
    <div>
      <h2>리뷰 삭제</h2>
      <p>리뷰 ID: {reviewId}</p>
      <form>
        <div>
          <label>비밀번호: </label>
          <input
            type="password"
            value={password}
            onChange={onValueChange}
            required
          />
        </div>
        
        <button type="button" onClick={onDelete}>삭제</button>
        <button type="button" onClick={() => navigate(-1)}>취소</button>
      </form>
    </div>
  );
}