package com.example.islameldesoky.bakingdesoky.businesslogic;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.islameldesoky.bakingdesoky.ui.recipelist.RecipeListActivity;
import com.example.islameldesoky.bakingdesoky.utils.App;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class RecipeController implements Callback<List<Recipe>> {

    static final String BASE_URL = "http://go.udacity.com/";

    private RecipeListActivity activity;

    public RecipeController(AppCompatActivity activity) {
        this.activity = (RecipeListActivity) activity;
    }

    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipeApi recipeApi = retrofit.create(RecipeApi.class);

        Call<List<Recipe>> call = recipeApi.getRecipes();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
        if (response.isSuccessful()) {
            Log.d("RC", response.body().toString());
            activity.setRecipes(response.body());
            App.getInstance().setRecipes(response.body());

        }
    }

    @Override
    public void onFailure(Call<List<Recipe>> call, Throwable t) {
        Log.d("RC", t.getMessage());
    }
}
