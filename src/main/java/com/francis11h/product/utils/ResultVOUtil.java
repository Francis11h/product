package com.francis11h.product.utils;

import com.francis11h.product.VO.ResultVO;

public class ResultVOUtil {
    /** 直接传一个 object 进去 再controller 外部完成 构造*/
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("success");
        return resultVO;
    }
}
