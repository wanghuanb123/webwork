package com.foods.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Foods {
    private Integer foodsId;
    private String foodsName;
    private Double foodsPrice;
    private String foodsInfo;
    private Type foodsType;

}
