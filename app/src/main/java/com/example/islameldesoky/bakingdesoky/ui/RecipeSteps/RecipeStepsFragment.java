package com.example.islameldesoky.bakingdesoky.ui.RecipeSteps;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.businesslogic.Steps;
import com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.adapter.RecipeStepsAdapter;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * Created by islam eldesoky on 12/07/2017.
 */

public class RecipeStepsFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";

    private RecipeStepsAdapter recipeStepsAdapter ;
    private RecyclerView rvSteps;
    private Bundle mBundle;
    SimpleExoPlayerView simpleExoPlayerView ;
    SimpleExoPlayer player ;
    private  Steps step ;
    private Recipe recipe;
    Handler mainHandler ;
    Uri VideoUri ;
    public RecipeStepsFragment(){



    } ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initializePlayer(VideoUri);


        mBundle = getArguments() == null ? getActivity().getIntent().getExtras() : getArguments();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_steps, container, false);


        if (mBundle != null) {
            recipe = (Recipe) mBundle.getSerializable(RecipeStepsFragment.ARG_ITEM_ID);

            rvSteps = (RecyclerView) rootView.findViewById(R.id.rv_steps);


            RecyclerView.LayoutManager manager = new LinearLayoutManager(rootView.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false);
            rvSteps.setLayoutManager(manager);

            recipeStepsAdapter = new RecipeStepsAdapter(recipe.getSteps());
            rvSteps.setAdapter(recipeStepsAdapter);
        }
       if(player==null){
            VideoUri = Uri.parse(step.getVideoURL());
            mainHandler = new Handler();
            TrackSelector trackSelector =
                    new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            simpleExoPlayerView = ((SimpleExoPlayerView) rootView.findViewById(R.id.step_video));
                    player =
                    ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
            simpleExoPlayerView.setPlayer(player);
            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getActivity(),
                    Util.getUserAgent(getActivity(), "BakingDesoky"), bandwidthMeter);

            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

            MediaSource videoSource = new ExtractorMediaSource(VideoUri,
                    dataSourceFactory, extractorsFactory, null, null);
            player.prepare(videoSource);
        }


        return rootView;
    }
    public void initializePlayer(Uri VideoUri){

    }
}
