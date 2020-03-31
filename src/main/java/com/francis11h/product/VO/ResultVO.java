package com.francis11h.product.VO;

import lombok.Data;

/**
 * Http 返回的 最外层对象
 * @param <T>
 */
@Data
public class ResultVO<T> {
    //错误码
    private Integer code;
    //提示信息
    private String message;
    /**
     * 这里的 data 我们用 范型 来表示 因为 data 里面可能是 不同类型的对象   
     * 本来类名儿 是 Result    要用范型 改为 Result<T> T 表示 范型 写法规范
     */
    private T data;
}
