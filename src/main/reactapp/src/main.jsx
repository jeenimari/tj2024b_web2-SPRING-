import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

const root = createRoot( document.querySelector('#root') )
//day02 : '컴포넌트 jsx 만들기'
  //import 호출할컴포넌트명 from '경로/파일명(확장자)';
  // import Example1 from'./example/1_동작구조/Example1.jsx'
  // root.render(<Example1/>)

  //day02: 컴포넌트의 props 활용
  // import Example2 from './example/2_컴포넌트/2_컴포넌트/Example2.jsx'
  // root.render(<Example2/>)

  import Task from './example/2_컴포넌트/2_컴포넌트/Task.jsx'
  root.render(<Task/>)
