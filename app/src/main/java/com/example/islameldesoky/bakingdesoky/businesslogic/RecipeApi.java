package com.example.islameldesoky.bakingdesoky.businesslogic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public interface RecipeApi {

    @GET("android-baking-app-json")
    Call<List<Recipe>> getRecipes();
}
