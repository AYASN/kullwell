package com.yandm.assir.model;

public class Ingredient {

   private Long id;
   private String name;

   private int calories;

   private String season;

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

   public int getCalories() {
      return calories;
   }

   public void setCalories(int calories) {
      this.calories = calories;
   }

   public String getSeason() {
      return season;
   }

   public void setSeason(String season) {
      this.season = season;
   }
}
