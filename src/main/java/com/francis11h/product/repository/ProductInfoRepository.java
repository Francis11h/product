package com.francis11h.product.repository;

import com.francis11h.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    //因为要查所有在架商品 所以 findByProductStatus
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
