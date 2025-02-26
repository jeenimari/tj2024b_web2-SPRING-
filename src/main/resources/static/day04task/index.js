//[1]글쓰기
const onWrite = async() => {
    const data = {

        title: document.querySelector('#title').value,
        content: document.querySelector('#content').value
    }
    try {
        if(data.title.length <= 0 || data.content.length <= 0) {
            alert('제목과 내용을 모두 입력해주세요.');
            return;
        }
        const response = await axios.post('/day04/task/board', data);
        if(response.data) {
            alert('글쓰기 성공');
            document.querySelector('#title').value = '';
            document.querySelector('#content').value = '';
            getList();
        } else {
            alert('글쓰기 실패');
        }
    } catch(e) {
        console.log(e);
        alert('글쓰기 실패');
    }
}

//[2]전체 글 조회
const getList = async() => {
    try {
        const response = await axios.get('/day04/task/board');
        let html = '';
        for(let i=0; i<response.data.length; i++) {
            html += `
                <tr>
                    <td>${response.data[i].bno}</td>
                    <td onclick="onView(${response.data[i].bno})">${response.data[i].title}</td>
                    <td>${response.data[i].content}</td>
                    <td>
                        <button onclick="onUpdate(${response.data[i].bno})">수정</button>
                        <button onclick="onDelete(${response.data[i].bno})">삭제</button>
                    </td>
                </tr>
            `
        }
        document.querySelector('tbody').innerHTML = html;
    } catch(e) {
        console.log(e);
    }
}
getList();

//[3]개별 글 조회
const onView = async(bno) => {
    try {
        const response = await axios.get(`/day04/task/board/view`, { params: { bno: bno } });
        if(response.data != null) {
            alert(`제목: ${response.data.title}\n내용: ${response.data.content}`);
        } else {
            alert('해당 게시글이 없습니다.');
        }
    } catch(e) {
        console.log(e);
    }
}

//[4]개별 글 수정
const onUpdate = async(bno) => {
    try {
        const title = prompt('수정할 제목');
        if(title == null || title.length <= 0) {return;}
        const content = prompt('수정할 내용');
        if(content == null || content.length <= 0) {return;}

        const response = await axios.put('/day04/task/board', {
            bno: bno,
            title: title,
            content: content
        });
        if(response.data) {
            alert('수정 성공');
            getList();
        } else {
            alert('수정 실패');
        }
    } catch(e) {
        console.log(e);
        alert('수정 실패');
    }
}

//[5]개별 글 삭제
const onDelete = async(bno) => {
    try {
        const response = await axios.delete('/day04/task/board', {
            params: { bno: bno }
        });
        if(response.data) {
            alert('삭제 성공');
            getList();
        } else {
            alert('삭제 실패');
        }
    } catch(e) {
        console.log(e);
        alert('삭제 실패');
    }
}
////[1]글쓰기
//const onWrite = async( )=>{
//    const data = {
//        title : document.querySelector('#title').value,
//        content : document.querySelector('#content').value
//    }
//    try{
//        const response = await fetch('day04/task/board', {    // 여기가 수정된 부분
//            method : 'post',
//            body:JSON.stringify(data),
//            headers: {'Content-Type': 'application/json'}
//        });
//        const result = await response.json();
//        if(result){
//            alert("글쓰기 성공");
//            document.querySelector('#title').value = '';
//            document.querySelector('#content').value = '';
//            getList();
//        }else{
//            alert('글쓰기 실패');
//        }
//    }catch(e){
//        console.log(e);
//    }
//}
//
////[2] 전체 글 조회
//const getList = async () => {
//    try {
//        const response = await fetch('/day04/task/board');
//        const boards = await response.json();
//        let html = '';
//        boards.forEach(board => {
//            html += `
//                <tr>
//                    <td>${board.bno}</td>
//                    <td onclick="onView(${board.bno})">${board.title}</td>
//                    <td>${board.content}</td>
//                    <td>
//                        <button onclick="onUpdate(${board.bno})">수정</button>
//                        <button onclick="onDelete(${board.bno})">삭제</button>
//                    </td>
//                </tr>
//            `
//        });
//        document.querySelector('tbody').innerHTML = html;
//    } catch(e) {
//        console.log(e);
//    }
//}
//getList();
//
////[3] 개별 글 조회
//const onView = async (bno) => {
//    try {
//        const response = await fetch(`/day04/task/board/view?bno=${bno}`);
//        const board = await response.json();
//        alert(`제목: ${board.title}\n내용: ${board.content}`);
//    } catch(e) {
//        console.log(e);
//    }
//}
//
//
////[4] 개별 글 수정
//const onUpdate = async (bno) => {
//    const title = prompt('수정할 제목');
//    const content = prompt('수정할 내용');
//
//    try {
//        const response = await fetch('/day04/task/board', {
//            method: 'put',
//            body: JSON.stringify({bno: bno, title: title, content: content}),
//            headers: {'Content-Type': 'application/json'}
//        });
//        const result = await response.json();
//        if(result){
//            alert('수정 성공');
//            getList();
//        } else {
//            alert('수정 실패');
//        }
//    } catch(e) {
//        console.log(e);
//    }
//}
//
////[5] 개별 글 삭제
//const onDelete = async (bno) => {
//    try {
//        const response = await fetch(`/day04/task/board?bno=${bno}`, {
//            method: 'delete'
//        });
//        const result = await response.json();
//        if(result){
//            alert('삭제 성공');
//            getList();
//        } else {
//            alert('삭제 실패');
//        }
//    } catch(e) {
//        console.log(e);
//    }
//}