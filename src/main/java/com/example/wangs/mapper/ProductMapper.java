package com.example.wangs.mapper;

import com.example.wangs.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface ProductMapper {

    Product selectById(String id);
    Product selectByName(String name);

}
