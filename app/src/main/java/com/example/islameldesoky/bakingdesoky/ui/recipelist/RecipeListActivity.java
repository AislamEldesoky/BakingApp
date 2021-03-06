package com.example.islameldesoky.bakingdesoky.ui.recipelist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.islameldesoky.bakingdesoky.IdlingResource.SimpleIdlingResource;
import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.businesslogic.RecipeController;
import com.example.islameldesoky.bakingdesoky.ui.recipelist.adapter.RecipeListAdapter;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private boolean mTwoPane;

    private RecipeListAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    private SimpleIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        recyclerView = (RecyclerView) findViewById(R.id.recipe_list);

        if (findViewById(R.id.recipe_detail_container) != null) {
            mTwoPane = true;
        }

        RecipeController controller = new RecipeController(this);
        controller.start();
    }

    public void setRecipes(List<Recipe> recipes) {
        if (adapter == null) {
            adapter = new RecipeListAdapter(recipes, mTwoPane, getSupportFragmentManager());
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setData(recipes);
        }
    }
}
