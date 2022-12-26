package com.heroku.whatscookingdoc.dao;

import com.heroku.whatscookingdoc.entity.Cuisine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {
}
