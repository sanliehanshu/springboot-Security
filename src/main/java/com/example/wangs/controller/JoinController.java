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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    //  根据 id 查询信息，并把结果信息封装成 Map
    @RequestMapping("/getAllProMap")
    public Map<String, Object>  getAllProMap(Integer id){
        Map<String, Object> proAsMapById = productmapper.getProAsMapById(id);
        log.info("proAsMapById:");
        return proAsMapById;
    }
    // 查询所有员工的信息，把数据库中的 'id' 字段作为 key,对应的 value 封装成 Employee 对象
    // @MapKey 中的值表示用数据库中的哪个字段名作 key
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

    /**
     * 传入是list
     * @return
     */
    @RequestMapping("/getAllProsByListId")
    List<Product> getAllProsByListId(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        List<Product> allProsByListId = productmapper.getAllProsByListId(list);
        log.info("根据list查询:");
        return allProsByListId;
    }

    /**
     * 传入的是array
     * @return
     */
    @RequestMapping("/getAllProsByArrayId")
    List<Product> getAllProsByArrayId(){
        int[] ints = {1, 2, 5};
        List<Product> allProsByListId = productmapper.getAllProsByArrayId(ints);
        log.info("根据array查询:");
        return allProsByListId;
    }

    /**
     * 传入map,根据时间进行判断
     * @return
     */
    @RequestMapping("/getAllProsByMap")
    List<Product> getAllProsByMap() {
        List<Integer> idList = new ArrayList<>();
        Map parmMap=new HashMap<String, Object>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);
        parmMap.put("idListS",idList);
        String date = "2020-05-04 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        parmMap.put("create_time",sdf.format(parse));
        List<Product> allProsByListId = productmapper.getAllProsByMap(parmMap);
        log.info("形参map查询开始啦！");
        return allProsByListId;
    }
}
