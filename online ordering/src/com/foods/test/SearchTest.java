package com.foods.test;

import com.foods.entity.Foods;
import com.foods.service.FoodsService;
import com.foods.vo.SearchVo;

import java.sql.SQLException;
import java.util.List;

public class SearchTest {
    public static void main(String[] args) throws SQLException {
        FoodsService foodsService = new FoodsService();
        SearchVo searchVo = new SearchVo(null,null,0.0,50.0,1);
        List<Foods> foods = foodsService.selectFoodsBySearchVO(searchVo);
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
        }
    }
}

