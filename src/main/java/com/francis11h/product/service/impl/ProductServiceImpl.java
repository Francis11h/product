package com.francis11h.product.service.impl;

import com.francis11h.product.dataobject.ProductInfo;
import com.francis11h.product.enums.ProductStatusEnum;
import com.francis11h.product.repository.ProductInfoRepository;
import com.francis11h.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.Up.getCode());
    }
}
