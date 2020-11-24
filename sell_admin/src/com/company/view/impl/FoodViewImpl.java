package com.company.view.impl;

import com.company.Dao.FoodDao;
import com.company.Dao.impl.FoodDaoImpl;
import com.company.domain.Food;
import com.company.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {

    private Scanner input = new Scanner(System.in);

    @Override
    public List<Food> showFoodList(Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> list = foodDao.listFoodByBusinessId(businessId);
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        String foodName = "";
        String foodExplain = "";
        Double foodPrice = 0.0;
        System.out.println("请输入食物名称:");
        foodName = input.next();
        System.out.println("请输入食物简介:");
        foodExplain = input.next();
        System.out.println("请输入食物价格（带小数点）:");
        foodPrice = input.nextDouble();
        Food food = new Food(null,foodName,foodExplain,foodPrice,businessId);
        FoodDao foodDao = new FoodDaoImpl();
        int result = foodDao.saveFood(food);
        if(result != 0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        String foodName = "";
        String foodExplain = "";
        Double foodPrice = 0.0;
        int foodId = 0;
        System.out.println("请输入食物编号:");
        foodId = Integer.parseInt(input.next());
        System.out.println("请修改食物名称:");
        foodName = input.next();
        System.out.println("请修改食物简介:");
        foodExplain = input.next();
        System.out.println("请修改食物价格（带小数点）:");
        foodPrice = input.nextDouble();
        Food food = new Food(foodId,foodName,foodExplain,foodPrice,businessId);
        FoodDao foodDao = new FoodDaoImpl();
        int result = foodDao.updateFood(food);
        if(result != 0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.println("请输入想要删除的食物编号:");
        int foodId = Integer.parseInt(input.next());
        FoodDao foodDao = new FoodDaoImpl();
        int result = foodDao.removeFood(foodId,businessId);
        if(result != 0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }
}
