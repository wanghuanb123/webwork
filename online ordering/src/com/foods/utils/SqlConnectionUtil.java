package com.foods.utils;

import com.foods.vo.SearchVo;

/*
* 拼接sql语句的工具类
* */
public class SqlConnectionUtil {

    public static String searchWhere(SearchVo searchVo){
        String wsql=" and 1=1 ";
        if (searchVo.getFoodsId()!=null){
            wsql += " and Foods_ID = "+ searchVo.getFoodsId();
        }
        if (searchVo.getFoodsName()!=null&&!"".equals(searchVo.getFoodsName())){
            wsql += " and Foods_Name like '%" + searchVo.getFoodsName()+"%'";
        }
        if (searchVo.getMinFoodsPrice()!=null&&!"".equals(searchVo.getMinFoodsPrice())){
            wsql += " and Foods_Price >= "+ searchVo.getMinFoodsPrice();
        }
        if (searchVo.getMaxFoodsPrice()!=null&&!"".equals(searchVo.getMaxFoodsPrice())){
            wsql += " and Foods_Price <= "+ searchVo.getMaxFoodsPrice();
        }
        if (searchVo.getTypeId()!=null){
            wsql += " and Foods_Type = " + searchVo.getTypeId();
        }
        return wsql;
    }
}
