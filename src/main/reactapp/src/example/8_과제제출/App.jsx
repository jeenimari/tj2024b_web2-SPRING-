import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';

// 라우터로 연결할 컴포넌트 import
import Home from './Home.jsx';
import BookCreate from './BookCreate.jsx';
import BookRead from './BookRead.jsx';
import BookDetail from './BookDetail.jsx';
import BookUpdate from './BookUpdate.jsx';
import BookDelete from './BookDelete.jsx';
import ReviewDelete from './ReviewDelete.jsx';
import NotFound from './NotFound.jsx';

export default function App(props) {
  return (
    <BrowserRouter>
      <div id="wrap">
        <header>
          <h1>익명 도서 추천 플랫폼</h1>
          <nav>
            <ul>
              <li><Link to="/">홈</Link></li>
              <li><Link to="/books">도서 목록</Link></li>
              <li><Link to="/books/create">도서 추천하기</Link></li>
            </ul>
          </nav>
        </header>
        
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/books" element={<BookRead />} />
          <Route path="/books/create" element={<BookCreate />} />
          <Route path="/books/detail" element={<BookDetail />} />
          <Route path="/books/update" element={<BookUpdate />} />
          <Route path="/books/delete" element={<BookDelete />} />
          <Route path="/reviews/delete" element={<ReviewDelete />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}