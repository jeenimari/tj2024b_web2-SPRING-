import axios from 'axios';

export default function Example1(props) {
    //[1]이벤트 함수
    const onEvent1 = (e) => {
        console.log(e);   //이벤트 매개변수
        // param1이 정의되지 않았으므로 제거
    }
    
    //[2]이벤트 함수 + 이벤트 결과 정보(e)매개변수
    const onEvent2 = (e, param1) => {
        console.log(e); //이벤트 매개변수
        console.log(param1); //일반매개 변수
    }
    
    //[3]axios get
    const onEvent3 = async () => {
        const response1 = await axios.get('https://jsonplaceholder.typicode.com/posts')
        console.log(response1.data);
        
        console.log('========================[2 GET]========================')
        const response2 = await axios.get('https://jsonplaceholder.typicode.com/posts/1')
        console.log(response2.data);
        
        console.log('================================[3 GET]============================')
        const response3 = await axios.get('https://jsonplaceholder.typicode.com/comments?postId=1')
        console.log(response3.data);
    }
    
    //[4]axios post test
    const onEvent4 = async () => {
        const obj = {userId: 1, title: 'foo', body: 'bar'}
        const response1 = await axios.post('https://jsonplaceholder.typicode.com/posts', obj) // URL 수정
        console.log(response1.data);
    }
    
    //[5]axios put test
    const onEvent5 = async () => {
        const obj = {id: 1, userId: 1, title: 'foo', body: 'bar'} //임의데이터
        const response1 = await axios.put('https://jsonplaceholder.typicode.com/posts/1', obj) // URL 수정
        console.log(response1.data);
    }
    
    //[6] axios delete test
    const onEvent6 = async () => {
        const response1 = await axios.delete('https://jsonplaceholder.typicode.com/posts/1') // URL 수정
        console.log(response1.data);
    }
    
    return (
        <>
            <button type='button' onClick={onEvent1}>이벤트함수1</button>
            <button type='button' onClick={(e) => {onEvent2(e, 13)}}>이벤트함수2</button>
            <button type='button' onClick={onEvent3}>이벤트함수3</button>
            <button type='button' onClick={onEvent4}>이벤트함수4</button>
            <button type='button' onClick={onEvent5}>이벤트함수5</button>
            <button type='button' onClick={onEvent6}>이벤트함수6</button>
        </>
    )
}