export default function Home(props) {
    return (
      <div>
        <h2>익명 도서 추천 플랫폼에 오신 것을 환영합니다!</h2>
        <p>이 사이트는 익명으로 도서를 추천하고 리뷰를 남길 수 있는 플랫폼입니다.</p>
        <p>다른 사용자들의 추천을 통해 새로운 책을 발견하고, 부담 없이 감상평을 나눠보세요.</p>
        <div>
          <a href="/books">도서 목록 보기</a> | 
          <a href="/books/create">도서 추천하기</a>
        </div>
      </div>
    );
  }