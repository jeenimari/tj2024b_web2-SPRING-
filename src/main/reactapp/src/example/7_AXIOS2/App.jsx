import{BrowserRouter, Route ,Routes} from 'react-router-dom'; // 'npm i react-router-dom '설치 필요


//라우터로 연결할 컴포넌트 import 가져온다.
import Home from'./Home.jsx'
import Create from'./Create.jsx'
import Read from'./Read.jsx'
import Update from'./Update.jsx'
import Delete from'./Delete.jsx'
import SideBar from './SideBar.jsx';
/*css import*/
import './app.css';

//App.jsx : 라우터(가상 URL)이용한 라이팅
export default function App(props){
    return(<>
        <BrowserRouter>{/*모든 라우터를 감싼다 */}
            <div id="wrap">

                <SideBar/>

                <Routes>{/*가상으로 정의한 URL을 감산다 */}
                    <Route path="/" element={<Home/>}/>{/*각 가상의 URL 정의함 .컴포넌트 연결 */}
                    <Route path="/create" element={<Create/>}/>{/*각 가상의 URL 정의함 .컴포넌트 연결 */}
                    <Route path="/read" element={<Read/>}/>{/*각 가상의 URL 정의함 .컴포넌트 연결 */}
                    <Route path="/update" element={<Update/>}/>{/*각 가상의 URL 정의함 .컴포넌트 연결 */}
                    <Route path="/delete" element={<Delete/>}/>{/*각 가상의 URL 정의함 .컴포넌트 연결 */}

                </Routes>



            </div>
        
        
        </BrowserRouter>

    </>)
}