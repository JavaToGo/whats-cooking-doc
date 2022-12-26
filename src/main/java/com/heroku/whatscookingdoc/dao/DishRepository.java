package com.heroku.whatscookingdoc.dao;

import com.heroku.whatscookingdoc.entity.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends CrudRepository<FoodItem, Integer> {
    List<FoodItem> findFoodItemsByCuisine_Id(Integer id);
}
