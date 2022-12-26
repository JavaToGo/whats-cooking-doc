package com.heroku.whatscookingdoc.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String mainIngredient;

    @Column
    private Integer cuisineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisineId", referencedColumnName = "id", insertable = false, updatable = false)
    @Getter (AccessLevel.NONE)
    private Cuisine cuisine;
}
