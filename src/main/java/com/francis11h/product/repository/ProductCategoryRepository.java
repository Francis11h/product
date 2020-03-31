package com.francis11h.product.repository;

import com.francis11h.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    //这里的 In 后面就得传一个 List 了
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
