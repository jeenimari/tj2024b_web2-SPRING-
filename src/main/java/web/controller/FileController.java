package web.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    //[1]업로드
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("multipartFile = " + multipartFile);
        System.out.println("FileController.fileUpload");
        String result = fileService.fileUpload(multipartFile);
        return result;
    }

    // http://localhost:8080/api/file/download?filename=r2.PNG
    //[2]업로드된 파일 다운로드
    @GetMapping("/download")
    public void fileDownload(@RequestParam String filename, HttpServletResponse response){
       fileService.fileDownload(filename,response);
    }
    //http://localhost:8080/api/file/delete?filename=[삭제할 파일명]
    //[3]업로드 된 파일 삭제
    @GetMapping("/delete")
    public void fileDelete(@RequestParam String filename){
        System.out.println("filename = " + filename);
        System.out.println("FileController.fileDelete");
        fileService.fileDelete(filename);
    }


}// c end
