package com.francis11h.product.service;


import com.francis11h.product.dataobject.ProductInfo;

import java.util.List;


public interface ProductService {
    /**
     * 查询所有在架商品 列表
     */
    List<ProductInfo> findUpAll();
}
