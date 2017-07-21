package com.example.islameldesoky.bakingdesoky;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.islameldesoky.bakingdesoky.ui.recipelist.RecipeListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by islam eldesoky on 19/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class RecyclerViewTests {


    @Rule
   public ActivityTestRule<RecipeListActivity> mRecipeAdapter = new ActivityTestRule<>(RecipeListActivity.class) ;

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    @Test

    public void Test (){

    }

}
