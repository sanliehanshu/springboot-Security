package com.example.wangs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Author sanliehanshu
 * @Date 2020-05-12 9:21
 * @Do  产品跟种类配置双向多对多
 */
@Table(name="product")
@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@GenericGenerator(name = "uuidH", strategy = "uuid")
public class Product {

    @Id
    @GeneratedValue(generator = "uuidH")
    private String id;
    private String name;
    private Date createTime;
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="category_id",referencedColumnName = "id")}
    )
    @ManyToMany
    private List<Category> category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
