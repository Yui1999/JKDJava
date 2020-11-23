package com.company.Dao.impl;

import com.company.Dao.FoodDao;
import com.company.domain.Food;
import com.company.utils.JDBCUtil;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class FoodDaoImpl implements FoodDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        ArrayList<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Food food = new Food();
                food.setFoodId(resultSet.getInt("foodId"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setFoodExplain(resultSet.getString("foodExplain"));
                food.setFoodPrice(resultSet.getDouble("foodPrice"));
                food.setBusinessId(resultSet.getInt("businessId"));
                list.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public int saveFood(Food food) {
        int foodId = 0;
        String sql = "insert into food value(null,?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                foodId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return foodId;
    }

    @Override
    public int updateFood(Food food) {
        int result = 0;
        String sql = "update food set foodName = ?,foodExplain = ?,foodPrice = ?,businessId = ?,where foodId = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            preparedStatement.setInt(5,food.getFoodId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId = ?";
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            result = preparedStatement.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            result = 0;
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection);
        }
        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId = ?";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                food = new Food();
                food.setFoodId(resultSet.getInt("foodId"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setFoodExplain(resultSet.getString("foodExplain"));
                food.setFoodPrice(resultSet.getDouble("foodPrice"));
                food.setBusinessId(resultSet.getInt("businessId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return food;
    }
}
