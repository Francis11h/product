package com.francis11h.product.service;

import com.francis11h.product.ProductApplicationTests;
import com.francis11h.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;


// 可以不写之前的 @RunWith(SpringRunner.class) @SpringBootTest 这两个注解
// 转而 继承 ProductApplicationTests， 该类前面声明了这两个注解  同时 前头加一个 @Component 即可
// 这种比以前的方便 因为 之后可能会有很多注解 不能每次 都重复写
@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> ans = productService.findUpAll();
        Assert.assertTrue(ans.size() > 0);
    }
}