package com.francis11h.product.service;

import com.francis11h.product.ProductApplicationTests;
import com.francis11h.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class CategoryServiceTest extends ProductApplicationTests {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> ans = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(ans.size() > 0);
    }
}