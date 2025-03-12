import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useLocation, Link } from "react-router-dom";

export default function BookDetail(props) {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const bookId = queryParams.get('book_id');
  
  const [book, setBook] = useState(null);
  const [reviews, setReviews] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  
  // 리뷰 작성 폼
  const [reviewForm, setReviewForm] = useState({
    book_id: bookId,
    content: '',
    pw: ''
  });

  useEffect(() => {
    console.log("Book ID:", bookId); // 디버깅을 위한 로그
    
    if (!bookId) {
      setError("도서 ID가 제공되지 않았습니다.");
      setLoading(false);
      return;
    }

    const fetchBookDetail = async () => {
      try {
        // 백엔드 API 엔드포인트 수정
        // 원래 API가 detail 엔드포인트가 아니라 /books/{bookId}로 설정되어 있을 수 있음
        // 첫 번째 시도: /books/detail?book_id={bookId}
        console.log("Fetching book details...");
        let response;
        try {
          response = await axios.get(`http://localhost:8080/day09/books/detail?book_id=${bookId}`);
        } catch (err) {
          // 첫 번째 방식으로 실패하면 두 번째 방식 시도
          console.log("First attempt failed, trying alternative endpoint");
          response = await axios.get(`http://localhost:8080/day09/books?book_id=${bookId}`);
        }
        
        console.log("Book data:", response.data);
        setBook(response.data);
        
        // 리뷰 목록 불러오기
        const reviewsResponse = await axios.get(`http://localhost:8080/day09/reviews`);
        console.log("Reviews data:", reviewsResponse.data);
        
        // 현재 도서의 리뷰만 필터링
        const filteredReviews = reviewsResponse.data.filter(
          review => Number(review.book_id) === Number(bookId)
        );
        setReviews(filteredReviews);
        setError(null);
      } catch (err) {
        console.error('데이터를 불러오는데 실패했습니다:', err);
        setError('데이터를 불러오는데 실패했습니다: ' + err.message);
      } finally {
        setLoading(false);
      }
    };
    
    fetchBookDetail();
  }, [bookId]);

  // 리뷰 폼 입력 처리
  const handleReviewChange = (e) => {
    setReviewForm({ ...reviewForm, [e.target.name]: e.target.value });
  };
  
  // 리뷰 등록 처리
  const handleReviewSubmit = async () => {
    if (!reviewForm.content.trim() || !reviewForm.pw) {
      alert('내용과 비밀번호를 모두 입력해주세요.');
      return;
    }
    
    try {
      const response = await axios.post('http://localhost:8080/day09/reviews', reviewForm);
      
      if (response.data === true) {
        alert('리뷰가 등록되었습니다.');
        // 폼 초기화
        setReviewForm({
          book_id: bookId,
          content: '',
          pw: ''
        });
        
        // 리뷰 목록 새로고침
        const reviewsResponse = await axios.get(`http://localhost:8080/day09/reviews`);
        const filteredReviews = reviewsResponse.data.filter(
          review => Number(review.book_id) === Number(bookId)
        );
        setReviews(filteredReviews);
      } else {
        alert('리뷰 등록에 실패했습니다.');
      }
    } catch (err) {
      console.error('리뷰 등록 중 오류 발생:', err);
      alert('서버 통신 중 오류가 발생했습니다.');
    }
  };
  
  const navigate = useNavigate();

  if (loading) return <div>로딩 중...</div>;
  if (error) return <div>오류: {error}</div>;
  if (!book) return <div>도서 정보를 찾을 수 없습니다. (Book ID: {bookId})</div>;

  return (
    <div>
      <div>
        <Link to="/books">목록으로 돌아가기</Link>
      </div>
      
      <h2>도서 상세 정보</h2>
      
      <div>
        <h3>{book.title}</h3>
        <p><strong>저자:</strong> {book.author}</p>
        <p><strong>소개:</strong> {book.intruduce}</p>
      </div>
      
      <div>
        <Link to={`/books/update?book_id=${bookId}`}>수정</Link> | 
        <Link to={`/books/delete?book_id=${bookId}`}>삭제</Link>
      </div>
      
      <div>
        <h3>리뷰 작성</h3>
        <div>
          <label>내용: </label>
          <textarea
            name="content"
            value={reviewForm.content}
            onChange={handleReviewChange}
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
            onChange={handleReviewChange}
            required
          />
        </div>
        
        <button type="button" onClick={handleReviewSubmit}>리뷰 등록</button>
      </div>
      
      <div>
        <h3>리뷰 목록</h3>
        {reviews.length === 0 ? (
          <p>아직 등록된 리뷰가 없습니다.</p>
        ) : (
          <div>
            {reviews.map(review => (
              <div key={review.review_id}>
                <p>{review.content}</p>
                <Link to={`/reviews/delete?review_id=${review.review_id}`}>삭제</Link>
                <hr />
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}