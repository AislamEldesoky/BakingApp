package com.example.islameldesoky.bakingdesoky.ui.StepsVideos;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.islameldesoky.bakingdesoky.R ;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import static com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.adapter.RecipeStepsAdapter.ARG_VIDEO_URL;

/**
 * Created by islam eldesoky on 17/07/2017.
 */

public class RecipeStepVideo extends AppCompatActivity implements ExoPlayer.EventListener {

    private String stepVideoUrl;
    SimpleExoPlayer player;
    SimpleExoPlayerView simpleExoPlayerView;
    Handler mainHandler;
    private static MediaSessionCompat mMediaSession;
    Uri VideoUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_video);
        simpleExoPlayerView = (SimpleExoPlayerView) findViewById(R.id.video_step);

        if (getIntent().getExtras().getString(ARG_VIDEO_URL) != null) {
            stepVideoUrl = getIntent().getExtras().getString(ARG_VIDEO_URL);
            if (player == null) {
                VideoUri = Uri.parse(stepVideoUrl);
                mainHandler = new Handler();
                TrackSelector trackSelector =
                        new DefaultTrackSelector();
                LoadControl loadControl = new DefaultLoadControl();
                player =
                        ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
                simpleExoPlayerView.setPlayer(player);
                player.addListener(this);
                DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                        Util.getUserAgent(this, "BakingDesoky"), bandwidthMeter);

                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

                MediaSource videoSource = new ExtractorMediaSource(VideoUri,
                        dataSourceFactory, extractorsFactory, null, null);
                player.prepare(videoSource);
                player.setPlayWhenReady(true);

            }
        }
    }

    private void releasePlayer() {
        player.stop();
        player.release();
        player = null;
    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray
            trackSelections) {

    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();

    }
}