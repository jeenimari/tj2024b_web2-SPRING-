import{use, useState}from "react"
export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    let [inputCount, setInputCount] = useState(0)
    let [inputText,SetInputText] = useState("")
    

    const handleChange = (event) => {
        const text = event.target.value;
        SetInputText(text); 
        setInputCount(text.length);
        


        // (2) 여기에서 state 변수값 수정하기.
        
    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={inputText}
            onChange={handleChange} />
            <p>글자 수{inputCount}: </p>
        </>
    )
}