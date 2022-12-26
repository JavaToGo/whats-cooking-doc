package com.heroku.whatscookingdoc.controller;

import com.heroku.whatscookingdoc.dao.DishRepository;
import com.heroku.whatscookingdoc.entity.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishRepository dishRepository;

    @Autowired
    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/suggestions")
    public Iterable<FoodItem> getAllDishes() {
        return dishRepository.findAll();
    }

    @GetMapping("/{id}")
    public FoodItem getDishById(@PathVariable("id") Integer id) {
        return dishRepository.findById(id).isPresent() ? dishRepository.findById(id).get() : null;
    }

    @PostMapping("/add")
    public FoodItem addDish(@RequestBody FoodItem foodItem) {
        return dishRepository.save(foodItem);
    }

    @GetMapping("/cuisine/{cuisineId}")
    public Iterable<FoodItem> getDishByCuisine(@PathVariable("cuisineId") Integer id) {
        return dishRepository.findFoodItemsByCuisine_Id(id);
    }
}
