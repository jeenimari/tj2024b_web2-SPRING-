import { Link } from 'react-router-dom';

export default function NotFound() {
  return (
    <div>
      <h2>404 - 페이지를 찾을 수 없습니다</h2>
      <p>요청하신 페이지가 존재하지 않습니다.</p>
      <Link to="/">홈으로 돌아가기</Link>
    </div>
  );
}