package com.udacity.sandwichclub.model;

import android.util.Log;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredientsString(){
        int len = ingredients.size();
        StringBuilder ing = new StringBuilder("");
        for(int a = 0; a < len; a++){
            ing.append(ingredients.get(a)).append(", ");
        }
        ing.deleteCharAt(ing.lastIndexOf(","));
        return ing.toString();
    }

    public String getAkaString(){
        if(alsoKnownAs.isEmpty()){
            return "";
        }

        int len = alsoKnownAs.size();
        StringBuilder aka = new StringBuilder("");
        for(int a = 0; a < len; a++){
            aka.append(alsoKnownAs.get(a)).append(", ");
        }
        aka.deleteCharAt(aka.lastIndexOf(","));
        return aka.toString();


    }

    public String getAlsoKnownAsString(){
        return null;
    }
}
