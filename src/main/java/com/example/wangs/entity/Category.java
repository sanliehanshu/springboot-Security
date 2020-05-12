package com.example.wangs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author sanliehanshu
 * @Date 2020-05-12 9:22
 * @Do  种类跟产品多对多
 */
@Table(name="category")
@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@GenericGenerator(name = "uuidH", strategy = "uuid")
public class Category {
    @Id
    @GeneratedValue(generator = "uuidH")
    private String id;
    @Column(name="categoryName")
    private String categoryName;
    private Date createTime;
    @ManyToMany(mappedBy = "category")
    private List<Product> products=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", createTime=" + createTime +
                ", products=" + products +
                '}';
    }
}
