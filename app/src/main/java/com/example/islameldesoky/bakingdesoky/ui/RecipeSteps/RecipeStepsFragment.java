package com.example.islameldesoky.bakingdesoky.ui.RecipeSteps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.adapter.RecipeStepsAdapter;
import com.example.islameldesoky.bakingdesoky.utils.App;
import com.orhanobut.hawk.Hawk;

import static com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment.ARG_POSITION;
import static com.example.islameldesoky.bakingdesoky.utils.App.ARG_RECIPES;

/**
 * Created by islam eldesoky on 12/07/2017.
 */

public class RecipeStepsFragment extends Fragment {

    private RecipeStepsAdapter recipeStepsAdapter;
    private RecyclerView rvSteps;
    private int position;
    private Recipe recipe;

    public RecipeStepsFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments() == null ?
                getActivity().getIntent().getIntExtra(ARG_POSITION, 1) :
                getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_steps, container, false);

        if (Hawk.get(ARG_RECIPES) != null) {
            recipe = App.getInstance().getRecipes().get(position);

            rvSteps = (RecyclerView) rootView.findViewById(R.id.rv_steps);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(rootView.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false);
            rvSteps.setLayoutManager(manager);

            recipeStepsAdapter = new RecipeStepsAdapter(recipe.getSteps());
            rvSteps.setAdapter(recipeStepsAdapter);
        }

        return rootView;
    }







  /*  public void initializePlayer(Uri VideoUri){
        if(player==null) {

            mainHandler = new Handler();
            TrackSelector trackSelector =
                    new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            player =
                    ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
            simpleExoPlayerView.setPlayer(player);
            player.addListener(this);
            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getActivity(),
                    Util.getUserAgent(getActivity(), "BakingDesoky"), bandwidthMeter);

            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

            MediaSource videoSource = new ExtractorMediaSource(VideoUri,
                    dataSourceFactory, extractorsFactory, null, null);
            player.prepare(videoSource);
        }
    }


    private void releasePlayer() {
        player.stop();
        player.release();
        player = null;
    }
*/


}
