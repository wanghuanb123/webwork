package com.foods.test;

import com.foods.service.FoodsService;

public class DeleteTest {
    public static void main(String[] args) {
        FoodsService foodsService = new FoodsService();
        foodsService.deleteFoodsByFoodsId(16);
    }
}
