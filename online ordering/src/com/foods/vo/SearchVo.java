package com.foods.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
* 查询实体类
* */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchVo {
    private Integer foodsId;
    private String foodsName;
    private Double minFoodsPrice;
    private Double maxFoodsPrice;
    private Integer typeId;
}
