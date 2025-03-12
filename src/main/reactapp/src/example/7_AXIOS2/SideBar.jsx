import {Link}from 'react-router-dom'

export default function SideBar(props){
    return(<>
    <div>
        <ul id='sideMenu'>
            <li>사이드바 메뉴</li>
            <li><Link to="/">메뉴1 : HOME</Link></li>
            <li><Link to="/create">메뉴2 : Create</Link></li>
            <li><Link to="/read">메뉴3 : Read</Link></li>
            <li><Link to="/update">메뉴4 : Update</Link></li>
            <li><Link to="/delete">메뉴5 : Delete</Link></li>
        </ul>
    </div>
    </>)
}