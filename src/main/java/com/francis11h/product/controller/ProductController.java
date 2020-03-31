package com.francis11h.product.controller;


import com.francis11h.product.VO.ProductVO;
import com.francis11h.product.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * 1. 查询所有在架的商品  查商品表 (使用 springJPA 来查询)
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {

    }

}
