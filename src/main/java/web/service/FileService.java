package web.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

@Service //해당 클래스가 서비스임을 빈 등록
public class FileService {

    //[*] 업로드 된 파일을 저장할 폴더 경로 잡기 ,resources(폴더)
    //src -> main ->resources - >static -> upload
    //1.현재 프로젝트 최상위 디렉토리(폴더) 경로찾기
    String baseDir = System.getProperty("user.dir");//현재 작업 최상위 폴더 반환
    //프로젝트의 절대경로 반환
    //2.src 와 build 폴더 차이점 : src(실행전 코드 : 개발자 ) vs build(실행 후 코드 : 사용자 )
    //*개발자는 src에서 작업하고 항상 서버를 실행 하므로써 작업한 코드를 build로 반영함 ( 컴파일)
    //*업로드는 개발자의 src에 업로드하지않고 배포/빌드 된 build 폴더에 업로드함
//    String uploadPath = "/src/resources/static/upload/";
    String uploadPath = baseDir+"/build/resources/main/static/upload/";

    //[1] 업로드 : 스프링에서는 MultipartFile 인터페이스 지원하므로 파일 업로드 지원
    public String fileUpload(MultipartFile multipartFile){//(1)매개변수로 'MultipartFile'인터페이스 타입받음


//        System.out.println(multipartFile.getContentType()); // 첨부파일의 확장자 반환
//        System.out.println(multipartFile.getSize()); //첨부파일의 용량(바이트) 반환
//        System.out.println(multipartFile.getOriginalFilename()); //첨부파일의 파일명 반환
//        System.out.println(multipartFile.isEmpty()); //첨부파일이 있다 없다 boolean반환




        //(3) 업로드할 경로만들기. // ' 업로드할 기본 경로' 와 (+)'파일명'

        String uuid = UUID.randomUUID().toString(); //UUID 규약에 따른 난수 문자열 생성( 고유성 보장)
        System.out.println("uuid = " + uuid);
            //(*)uuid 와(+)파일명(파일명에_ 언더바가 존재하면 -하이픈으로 모두 변경 ) , -언더바는 uuid와 파일명 구분하는 용도
        String fileName = uuid + "_"+ multipartFile.getOriginalFilename().replaceAll("_","-");
            //(*)업로드 기본 경로 +uuid 포함된 파일명
        String filePath = uploadPath + fileName;
            //(*)만일 업로드 경로가 존재하지 않으면
        File file2 = new File(uploadPath);
        if(file2.exists()){file2.mkdir();}

        //(4)File 클래스 //파일관련된 다양메소드 제공하는 클래스
        File file = new File(filePath); //new File(파일이 존재하는 경로);
        //(5)업로드하기
        try {
            multipartFile.transferTo(file);
        }catch (IOException e){
            System.out.println(e); return null; //만일 업로드 실패시 null반환
        }
        return fileName; //만약에 업로드 성공시 업로드한 파일명 반환
    }



    //[2] 업로드 된 파일 다운로드  req 요청객체 , resp 응답객체
    //사용자 -> HTTP --> 서버-->fileInputStream --> c: ~~buld
    //[사용자]<--HTTP --[서버]  <--fileInputStram<---
    //*HTTP : 문자 전송 , 대용량 파일(첨부파일)은 바이트(바이너리) 로 전송
    public void fileDownload(String filename , HttpServletResponse response){//(1)다운로드할 파일명과 HTTP응답객체 받기
        //(1)사용자로부터 다운로드 받을 파일명과 HTTP 응답 객체 받음

        //(2)다운로드 할 파일의 경로조합(기본 경로 + 다운로드할 파일명)
        String downloadPath = uploadPath + filename; //soutv 가장가까운 변수 출력
        System.out.println("downloadPath = " + downloadPath);
        //(3) 만일 다운로드할 파일이 존재하지 않으면 리턴
        File file = new File(downloadPath);
        if(!file.exists()){return;} // 다운로드 취소/안함
        //(4)업로드된 파일을 자바(바이트) 로 가져오기
        //*스트림 ?  : 바이트(데이터)가 다니는 통로 ,대용량(첨부파일)에서는 무조건 바이트 전송해야함.

        try { //1.파일 입력스트림 객체 생성  예외처리 무조건 발생 파일에 관련된 건 거의 발생함
            FileInputStream fin = new FileInputStream(downloadPath);
            //2.해당하는 파일의 용량만큼 배열 선언
          long fileSize = file.length(); //파일의 용량
            byte[] bytes = new byte[(int)fileSize]; // 파일의 용량만큼 배열선언 ,배열은 int 타입으로 크기 설정
            //3.파일 입력스트림 객체로 파일 읽어오기 , .read(바이트배열)
            fin.read(bytes);
            System.out.println(Arrays.toString(bytes)); //확인용
            //4.파일 입력 스트림 닫기 , .close()
            fin.close();  //입력 스트림의 메모리를 직접 닫아줌 . 생략시 일정시간 지난후 GC가 삭제함


            //5.가져온 파일을 HTTP response 내보내기
            //  response.setHeader("Content-Dispostion" , "attachment;filename =다운로드에 표시할 파일명");
            //*HTTP 응답 객체의 헤더 속성 추가 ,브라우저에게 다운로드 형식임을 알리기
            //*파일명에 한글이 존재하면 깨진다 HTTP는 본래 한글 지원안함 ( 인코딩 필요)
                //URLEncoder.encode(한글파일명 ,"UTF-8")
            String oldFilename = URLEncoder.encode(filename.split("_")[1] , "UTF-8"); //UUID(사용자에게 보여줄 필요없음 ) 은 제거
            response.setHeader("Content-Dispostion" , "attachment;filename ="+filename);
                //1.서블릿 출력스트림 객체생성
            ServletOutputStream fout = response.getOutputStream();
                //2.서블릿 출력스트림 객체 이용한 읽어온 바이트 내보내기
            fout.write(bytes);
                //3.서블릿 출력스트림 객체 닫기
            fout.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //[3] 업로드된 파일 삭제

    public boolean fileDelete(String filename){ //(1)삭제할 파일명을 매개변수로 받는다.
        String filePath = uploadPath + filename;    //(2)업로드경로 와 삭제할 파일명 연결함
        File file = new File(filePath); //(3)new File(파일경로);
        if(file.exists()){ //(4) . exists(): 경로상의 파일이 존재하면 true아니면 false 반환
            file.delete(); //(5) . delete( ) : 경로상의 파일 삭제
            return true;
        }
        return false;
    }// fend

}// cend
