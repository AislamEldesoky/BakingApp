package com.example.islameldesoky.bakingdesoky;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;

import com.example.islameldesoky.bakingdesoky.ui.recipelist.RecipeListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by islam eldesoky on 18/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class SimpleUiRecipeTestsActivity extends Fragment {

    @Rule
    public ActivityTestRule<RecipeListActivity> recipeListActivityActivityTestRule = new ActivityTestRule<>(RecipeListActivity.class);

    @Test
    public void simpleTest(){
        onView(withId(R.id.frameLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.app_bar)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    }



}
