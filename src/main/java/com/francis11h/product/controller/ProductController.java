package com.francis11h.product.controller;


import com.francis11h.product.VO.ProductInfoVO;
import com.francis11h.product.VO.ProductVO;
import com.francis11h.product.VO.ResultVO;
import com.francis11h.product.dataobject.ProductCategory;
import com.francis11h.product.dataobject.ProductInfo;
import com.francis11h.product.service.CategoryService;
import com.francis11h.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired  //这里 必须要写  一个 注入写一个。。。。 大bug
    private CategoryService categoryService;

    /**
     * 1. 查询所有 在架 的商品  查商品表 (使用 springJPA 来查询)
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        /** 1. 查询所有 上架的 商品 */
        List<ProductInfo> productInfoList = productService.findUpAll();
        /** 2. 所有商品列表中 把所有的 categoryType 取出来 并重新放入一个list里面 用 lambada 表达式 */

        List<Integer> categoryTypeList = productInfoList.stream()    // 变为流先
                .map(ProductInfo::getCategoryType)                   // 要 ProductInfo 这个类里的 categoryType属性 用 getCategoryType方法
                .collect(Collectors.toList());                       // 重新组装成 list

        /** 3.  根据categoryType查 类目  因为最后要的数据 是根据 type 来排列的*/
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /** 4. 构造数据 */
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            // type 确定
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            // 这里才是 每个商品的 的信息
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                // 该type的商品
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // 拷贝的工具类 只考相同的有的部分
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            // 把所有同type的商品 放进去
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMessage("success");
        return resultVO;
    }

}
