package com.example.islameldesoky.bakingdesoky.utils;

import android.app.Application;

import com.example.islameldesoky.bakingdesoky.businesslogic.Ingredient;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * Created by islam eldesoky on 15/07/2017.
 */

public class App extends Application {

    private static App instance;

    public static final String ARG_RECIPES = "recipes";
    public static final String ARG_INGREDIENTS = "ingredients";
    public static final String LAST_POS_CLICKED = "last_pos_clicked";
    int position = 0;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }

    public static App getInstance() {
        return instance;
    }

    public void setRecipes(List<Recipe> recipes) {
        Hawk.put(ARG_RECIPES, recipes);
    }

    public void setIngredients(List<Ingredient> ingredients) {
        Hawk.put(ARG_INGREDIENTS, ingredients);
    }

    public List<Recipe> getRecipes() {
        return Hawk.get(ARG_RECIPES);
    }

    public List<Ingredient> getIngredients() {
        return Hawk.get(ARG_INGREDIENTS);
    }

    public int getPosition() {
        return position;
    }
}
