package com.heroku.whatscookingdoc.controller;

import com.heroku.whatscookingdoc.dao.CuisineRepository;
import com.heroku.whatscookingdoc.entity.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuisine")
public class CuisineController {

    private final CuisineRepository cuisineRepository;

    @Autowired
    public CuisineController(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping
    @ResponseBody
    public Iterable<Cuisine> getAllCuisines() {
        return cuisineRepository.findAll();
    }

    @PostMapping("/add")
    public void addCuisine(@RequestBody Cuisine cuisine) {
        cuisineRepository.save(cuisine);
    }

    @DeleteMapping("/remove/{id}")
    public Cuisine deleteCuisine(@PathVariable("id") Integer id) {
        Cuisine deleteMe = null;
        if (cuisineRepository.findById(id).isPresent()) {
            deleteMe = cuisineRepository.findById(id).get();
            cuisineRepository.delete(deleteMe);
        }

        return deleteMe;
    }

}
