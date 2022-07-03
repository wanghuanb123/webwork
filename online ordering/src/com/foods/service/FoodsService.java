package com.foods.service;

import com.foods.dao.FoodsDAO;
import com.foods.entity.Foods;
import com.foods.utils.ConnectionUtil;
import com.foods.vo.SearchVo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FoodsService {

    private FoodsDAO foodsDAO = new FoodsDAO();
 /*
 * 保存菜品的方法
 *
 * */
    public Boolean addfoods(Foods foods){
        Connection connection = ConnectionUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            if (foodsDAO.findFoodsByFoodsName(foods.getFoodsName(),connection)==null){
                foodsDAO.addMenus(foods,connection);
//                手动提交事务
                connection.commit();
            }else {
                throw  new RuntimeException("菜品已存在，请重新输入!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
//            出现异常，回滚事务
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw  new RuntimeException(throwables); //等同于返回
        } finally {
//            关闭资源
            ConnectionUtil.closeConnection(connection);
        }
        return true;
    }


/*
* 查询所有菜品的方法
* */
    public List<Foods> selectAllFoods(){
        Connection connection = ConnectionUtil.getConnection();
        try {
            return foodsDAO.showMenus(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
    * 按菜品名字查询菜品的方法
    * */
    public List<Foods> selectFoodsByFoodsName(String foodsName){
        Connection connection = ConnectionUtil.getConnection();

        try {
            List<Foods> foodsList = foodsDAO.showFoosByFoodsName(foodsName, connection);
            return foodsList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
     * 按菜品类型查询菜品的方法
     * */
    public List<Foods> selectFoodsByTypeId(int typeId){
        Connection connection = ConnectionUtil.getConnection();

        try {
            List<Foods> foodsList = foodsDAO.showFoosByTypeId(typeId, connection);
            return foodsList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
     * 按菜号查询菜品的方法
     * */
    public Foods selectFoodsByFoodsId(int foodsId){
        Connection connection = ConnectionUtil.getConnection();

        try {
            return foodsDAO.findFoosByFoodsId(foodsId,connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
    * 修改菜品的方法
    * */
    public Boolean alterFoods(Foods foods,String oldfoodsName){

        Connection connection = ConnectionUtil.getConnection();

            try {
                if(oldfoodsName==foods.getFoodsName()){
                    if(foodsDAO.showFoosByFoodsName(foods.getFoodsName(),connection)!=null){
                        throw  new RuntimeException("商品名称已存在，请重新输入");
                    }
                }
                connection.setAutoCommit(false);
                foodsDAO.alterFoodsByFoodsID(foods,connection);
                connection.commit();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException(throwables);
            }finally {
                ConnectionUtil.closeConnection(connection);
            }
    }

    /*
     * 多重查询菜品的方法
     * */
    public List<Foods> selectFoodsBySearchVO(SearchVo searchVo){
        Connection connection = ConnectionUtil.getConnection();

        try {
            List<Foods> foodsList = foodsDAO.showFoosBySearchVO(searchVo, connection);
            return foodsList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }finally {
            ConnectionUtil.closeConnection(connection);
        }
    }

    /*
    *删除菜品的方法
    * */
    public void deleteFoodsByFoodsId(int foodsId){

        Connection connection = ConnectionUtil.getConnection();

        try {
            connection.setAutoCommit(false);

            foodsDAO.deleteFood(foodsId,connection);

            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw  new RuntimeException(throwables);
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }
}
