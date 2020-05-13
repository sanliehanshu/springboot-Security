package com.example.wangs.controller;

import com.example.wangs.entity.Product;
import com.example.wangs.entity.Role;
import com.example.wangs.entity.User;
import com.example.wangs.mapper.ProductMapper;
import com.example.wangs.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wangsheng
 */
@RestController
public class JoinController {
    @Autowired
    UserMapper usermapper;
    @Autowired
    ProductMapper productmapper;

    Logger log = LoggerFactory.getLogger(JoinController.class);


    @RequestMapping("/test")
    public List<Role> test(@RequestParam String id){
        List<Role> rolesByHrId = usermapper.getRolesByUserId(id);
        return rolesByHrId;
    }

    @RequestMapping("/userList")
    public User userList(@RequestParam String username){
        User user = usermapper.loadUserByUsername(username);
        return user;
    }

    @RequestMapping("/productList")
    public Product productList(@RequestParam String id){
        Product product = productmapper.selectById(id);
        return product;
    }
    @RequestMapping("/productListByName")
    public Product productListByName(@RequestParam String name){
        Product product = productmapper.selectByName(name);
        return product;
    }
    @RequestMapping("/productByName")
    public String productByName(@RequestParam Integer id){
        String product = productmapper.getProductById(id);
        log.info("productByName:");
        return product;
    }

    @RequestMapping("/getAllPro")
    public List<Product>  getAllPro(){
        List<Product> allProduct = productmapper.getAllProduct();
        log.info("productByName:");
        return allProduct;
    }

    @RequestMapping("/getAllProMap")
    public Map<String, Object>  getAllProMap(Integer id){
        Map<String, Object> proAsMapById = productmapper.getProAsMapById(id);
        log.info("proAsMapById:");
        return proAsMapById;
    }

    @RequestMapping("/getAllProsAsMap")
    public Map<String, Product> getAllProsAsMap(){
        Map<String, Product> proAsMapById = productmapper.getAllProsAsMap();
        log.info("proAsMapById:");
        return proAsMapById;
    }


    @RequestMapping("/getAllProsAsMapM")
    Map<String, Map<String,Product>> getAllProsAsMapM(){
        Map<String, Map<String, Product>> allProsAsMapM = productmapper.getAllProsAsMapM();
        log.info("proAsMapById:");
        return allProsAsMapM;
    }
}
