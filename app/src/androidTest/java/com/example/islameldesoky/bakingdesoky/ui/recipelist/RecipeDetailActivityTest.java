package com.example.islameldesoky.bakingdesoky.ui.recipelist;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by islam eldesoky on 22/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class RecipeDetailActivityTest {


    @Rule
    public ActivityTestRule<RecipeDetailActivity> mTestDetailActivity = new ActivityTestRule<>(RecipeDetailActivity.class);



    @Test
    public void TestDetails (){
        onView(withId(R.id.view_steps)).check(matches(isClickable()));
        onView(withId(R.id.view_steps)).perform(click());
    }

@Test
    public void TestRecycler (){
    onView(withId(R.id.rv_ingredients)).perform(RecyclerViewActions.scrollToPosition(1));

}

}
