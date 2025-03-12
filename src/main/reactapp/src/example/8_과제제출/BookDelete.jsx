import { useState } from "react";
import axios from "axios";
import { useNavigate, useLocation, Link } from "react-router-dom";

export default function BookDelete(props) {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const bookId = queryParams.get('book_id');
  
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  const onValueChange = (e) => {
    setPassword(e.target.value);
  };
  
  const navigate = useNavigate();
  const onDelete = async () => {
    if (!password) {
      setError('비밀번호를 입력해주세요.');
      return;
    }
    
    try {
      setLoading(true);
      setError(null);
      // 백엔드 API에 맞게 DELETE 요청 방식 수정
      const response = await axios.delete(`http://localhost:8080/day09/books?book_id=${bookId}&pw=${password}`);
      
      if (response.data === true) {
        alert('도서가 삭제되었습니다.');
        navigate('/books');
      } else {
        setError('도서 삭제 실패: 비밀번호가 일치하지 않거나 시스템 오류');
      }
    } catch (err) {
      console.error('도서 삭제 중 오류 발생:', err);
      setError('서버 통신 중 오류가 발생했습니다.');
    } finally {
      setLoading(false);
    }
  };
  
  if (!bookId) {
    return (
      <div>
        <h2>오류</h2>
        <p>도서 ID가 제공되지 않았습니다.</p>
        <Link to="/books">도서 목록으로 돌아가기</Link>
      </div>
    );
  }
  
  return (
    <div>
      <h2>도서 삭제</h2>
      <p>도서 ID: {bookId}</p>
      {error && <p style={{ color: 'red' }}>{error}</p>}
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
        
        <button type="button" onClick={onDelete} disabled={loading}>
          {loading ? '처리 중...' : '삭제'}
        </button>
        <button type="button" onClick={() => navigate(`/books/detail?book_id=${bookId}`)}>취소</button>
      </form>
    </div>
  );
}