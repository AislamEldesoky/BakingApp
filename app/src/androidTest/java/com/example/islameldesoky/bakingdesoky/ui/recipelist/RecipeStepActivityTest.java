package com.example.islameldesoky.bakingdesoky.ui.recipelist;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.RecipeStepsActivity;

import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by islam eldesoky on 22/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class RecipeStepActivityTest {

    @Rule
    public ActivityTestRule<RecipeStepsActivity> mTestStepActivity = new ActivityTestRule<>(RecipeStepsActivity.class) ;

    @Test
    public void TestStepsAdapter (){
        onView(withId(R.id.rv_steps)).perform(RecyclerViewActions.scrollToPosition(1));

    }

}
