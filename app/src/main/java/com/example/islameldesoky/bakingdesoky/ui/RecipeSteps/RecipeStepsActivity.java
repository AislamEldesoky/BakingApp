package com.example.islameldesoky.bakingdesoky.ui.RecipeSteps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Steps;

/**
 * Created by islam eldesoky on 12/07/2017.
 */

public class RecipeStepsActivity extends AppCompatActivity {

    private Steps step ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.recipe_steps_container, new RecipeStepsFragment())
                    .commit();
        }
    }


   /* public class Exomediaplayer extends VideoView implements OnPreparedListener {
        VideoView videoView;

        public Exomediaplayer(Context context, VideoView videoView) {
            super(context);
            this.videoView = videoView;
        }


    }*/

}
