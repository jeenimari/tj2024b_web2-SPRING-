import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Delete(props){
    const [deleteid, setDeleteid] = useState("");
    
    const onValueChange = (e) => {
        setDeleteid(e.target.value);
    }
    
    const navigate = useNavigate();
    const onDelete = async() => {
        const response = await axios.delete(`http://localhost:8080/day08/products?id=${deleteid}`);
        if(response.data == true) {
            alert('삭제성공');
            navigate('/read');
        } else {
            alert('삭제실패: 없는 제품번호이거나 시스템 오류');
        }
    }
    
    return(<>
        <div>
            <h3>Delete페이지</h3>
            <form>
                삭제할 제품번호: <input value={deleteid} onChange={onValueChange}/><br/>
                <button type="button" onClick={onDelete}>삭제</button>
            </form>
        </div>
    </>);
}