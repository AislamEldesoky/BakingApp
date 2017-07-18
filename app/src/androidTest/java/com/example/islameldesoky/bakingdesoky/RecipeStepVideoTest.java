package com.example.islameldesoky.bakingdesoky;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.islameldesoky.bakingdesoky.ui.StepsVideos.RecipeStepVideo;

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
public class RecipeStepVideoTest {
    @Rule
    public ActivityTestRule<RecipeStepVideo> stepVideoActivityTestRule = new ActivityTestRule<>(RecipeStepVideo.class);

    @Test
    public void videoTest(){
        onView(withId(R.id.step_video)).check(matches(isDisplayed()));
    }
}
