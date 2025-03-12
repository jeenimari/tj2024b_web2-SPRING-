import { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function BookRead(props) {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await axios.get('http://localhost:8080/day09/books');
        setBooks(response.data);
        setError(null);
      } catch (err) {
        console.error('도서 목록을 불러오는데 실패했습니다:', err);
        setError('도서 목록을 불러오는데 실패했습니다.');
      } finally {
        setLoading(false);
      }
    };

    fetchBooks();
  }, []);

  if (loading) return <div>로딩 중...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div>
      <h2>도서 추천 목록</h2>
      
      {books.length === 0 ? (
        <div>
          <p>추천된 도서가 없습니다. 첫 번째 추천자가 되어보세요!</p>
          <Link to="/books/create">도서 추천하기</Link>
        </div>
      ) : (
        <table>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>저자</th>
              <th>상세보기</th>
            </tr>
          </thead>
          <tbody>
            {books.map((book) => (
              <tr key={book.book_id}>
                <td>{book.book_id}</td>
                <td>{book.title}</td>
                <td>{book.author}</td>
                <td>
                  <Link to={`/books/detail?book_id=${book.book_id}`}>상세보기</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}