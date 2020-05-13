package com.example.wangs.mapper;

import com.example.wangs.entity.Product;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public interface ProductMapper {

    Product selectById(String id);
    Product selectByName(String name);
    //测试resultType  返回String 测试Integer 自动转型String
    String getProductById(Integer id);
    List<Product> getAllProduct();
    //  根据 id 查询信息，并把结果信息封装成 Map
    Map<String, Object> getProAsMapById(Integer id);
    // 查询所有员工的信息，把数据库中的 'id' 字段作为 key,对应的 value 封装成 Employee 对象
    // @MapKey 中的值表示用数据库中的哪个字段名作 key
    @MapKey("id")
    Map<String, Product> getAllProsAsMap();

    @MapKey("id")
    Map<String, Map<String,Product>> getAllProsAsMapM();

}
