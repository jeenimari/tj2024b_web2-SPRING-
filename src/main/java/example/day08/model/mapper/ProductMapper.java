package example.day08.model.mapper;

public interface ProductMapper {
<<<<<<< HEAD
    //[2]전체조회
    @Select("select * from productsample")
    public List<ProductDto>onRead();

    //[1]제품등록,dto의 멤버변수와 db테이블의 속성명은 동일하게(관례/권장)
    @Insert("insert into productsample(name,price,comment)"+
            " values(#{name},#{price},#{comment})")
    public boolean onCreate(ProductDto productDto);

    //[3]제품 수정
    @Update("update productsample "+"set name=#{name},price=#{price},comment=#{comment}"+
    " where id=#{id}")
    public boolean onUpdate(ProductDto productDto);

    //[4] 제품삭제
    @Delete("delete from productsample where id=#{id}")
    public boolean onDelete(int id);
=======
>>>>>>> parent of f6e11cf (2025-03-11 수업끝)
}
