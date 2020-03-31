package com.francis11h.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 类名 要跟数据库里面的 表名 保持一致
 * 不一致的话 要写 @Table（name = "，，，，"）注解
 */

@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    /**小图地址*/
    private String productIcon;

    /**状态 0正常 1下架
     *  默认为在架的状态 这样子 new 的时候 就已经有值了 否则 这个 到后面传的时候 是 null
     */

    private Integer productStatus;

    /**类目编号*/
    private Integer categoryType;


    private Date createTime;

    private Date updateTime;
}
