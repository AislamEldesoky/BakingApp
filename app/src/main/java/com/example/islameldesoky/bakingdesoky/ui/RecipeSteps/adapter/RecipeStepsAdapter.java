package com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Steps;
import com.example.islameldesoky.bakingdesoky.ui.StepsVideos.RecipeStepVideo;

import java.util.List;

/**
 * Created by islam eldesoky on 12/07/2017.
 */

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.ViewHolder> {

    private List<Steps> steps;

    public static final String ARG_VIDEO_URL = "video_url";

    public RecipeStepsAdapter(List<Steps> steps) {
        this.steps = steps;
    }


    @Override
    public RecipeStepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_steps_list, parent, false);
        return new RecipeStepsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeStepsAdapter.ViewHolder holder, final int position) {
        holder.mItem = steps.get(position);
        holder.mDescription.setText(steps.get(position).getDescription());
        holder.mId.setText(steps.get(position).getId());
        holder.mShortDescription.setText(steps.get(position).getShortDescription());

        Glide.with(holder.mView.getContext())
                .load(steps.get(holder.getAdapterPosition()).getThumbnailURL())
                .into(holder.mVideoThumbnail);

        holder.mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.mView.getContext(), RecipeStepVideo.class);
                intent.putExtra(ARG_VIDEO_URL, steps.get(holder.getAdapterPosition()).getVideoURL());
                holder.mView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mId;
        final TextView mShortDescription;
        final TextView mDescription;
        final RelativeLayout mVideo;
        final ImageView mVideoThumbnail;
        Steps mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mId = (TextView) view.findViewById(R.id.stepID);
            mShortDescription = (TextView) view.findViewById(R.id.step_ShortDescription);
            mDescription = (TextView) view.findViewById(R.id.step_Description);
            mVideo = (RelativeLayout) view.findViewById(R.id.step_video);
            mVideoThumbnail = (ImageView) view.findViewById(R.id.step_video_thumbnail);
        }
    }
}
