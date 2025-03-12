package example.day08.controller;

<<<<<<< HEAD
import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day08/products") //공통 url 정의
@CrossOrigin("http://localhost:5173")//리액트 포트 도메인 허락
public class ProductController {

    //(1)서비스 메소드를 사용하기 위한 객체 주입
    @Autowired private ProductService productService;
    //[2]전체 조회
    @GetMapping("") //1.http://localhost:8080/day08/products
   public List<ProductDto> onRead(){
        System.out.println("ProductController.onRead");
        return productService.onRead(); //샘플
    }// fend


    @PostMapping("")
    public boolean onCreate(@RequestBody ProductDto productDto){

        System.out.println("productDto = " + productDto);
        return productService.onCreate(productDto);
    }

//    @PostMapping("")
//    public void onUpdate(@RequestBody ProductDto productDto){
//        //{"id":"1","name":"카제인","price":"20000","comment":"맛있는카제인"}
//        System.out.println("ProductController.onUpdate");
//        System.out.println("productDto="+productDto);
//    }//f end

    @PutMapping("")
    public boolean onUpdate1(@RequestBody ProductDto productDto){
        System.out.println("ProductController.onUpdate");
        System.out.println("productDto = " + productDto);
        return productService.onUpdate(productDto);
    }// f end

    //[4]제품삭제
    @DeleteMapping("")
    public boolean onDelete(@RequestParam int id){
        System.out.println("ProductController.onDelete");
        System.out.println("id = " + id);
        return productService.onDelete(id);
    }

=======
public class ProductController {
>>>>>>> parent of f6e11cf (2025-03-11 수업끝)
}
