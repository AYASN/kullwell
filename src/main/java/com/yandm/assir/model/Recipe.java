package com.yandm.assir.model;

import java.util.List;

public class Recipe {

    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private List<Long> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<Long> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Long> ingredients) {
        this.ingredients = ingredients;
    }

}
