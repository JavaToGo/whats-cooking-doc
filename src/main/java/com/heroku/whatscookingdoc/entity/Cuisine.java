package com.heroku.whatscookingdoc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cuisine {

    public Cuisine() {
    }

    public Cuisine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(targetEntity = FoodItem.class, mappedBy = "cuisine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FoodItem> dishes = new ArrayList<>();

    @Override
    public String toString() {
        return "Cuisine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
