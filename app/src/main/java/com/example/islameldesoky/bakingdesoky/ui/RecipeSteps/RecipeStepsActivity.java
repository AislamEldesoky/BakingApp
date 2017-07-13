package com.example.islameldesoky.bakingdesoky.ui.RecipeSteps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.islameldesoky.bakingdesoky.R;

/**
 * Created by islam eldesoky on 12/07/2017.
 */

public class RecipeStepsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.recipe_steps_container, new RecipeStepsFragment())
                .commit();
    }


}
