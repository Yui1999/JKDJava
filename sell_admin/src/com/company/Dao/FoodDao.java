package com.company.Dao;

import com.company.domain.Food;
import org.omg.CORBA.PUBLIC_MEMBER;
import java.util.List;

public interface FoodDao {
    public List<Food> listFoodByBusinessId(Integer businessId );
    public int saveFood(Food food);
    public int updateFood(Food food);
    public int removeFood(Integer foodId,Integer businessId);
    public  Food getFoodById(Integer foodId);
}
