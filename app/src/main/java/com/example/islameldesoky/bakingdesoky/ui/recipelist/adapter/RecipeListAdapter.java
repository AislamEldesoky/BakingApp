package com.example.islameldesoky.bakingdesoky.ui.recipelist.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Ingredient;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailActivity;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class RecipeListAdapter
        extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    public static final String LAST_POS_CLICKED = "last_pos_clicked";
    private List<Recipe> recipes;
    private List<Ingredient> ingredients;
    private final boolean mTwoPane;
    private final FragmentManager fragmentManager;

    public RecipeListAdapter(List<Recipe> recipes, boolean mTwoPane, FragmentManager fragmentManager) {
        this.recipes = recipes;
        this.mTwoPane = mTwoPane;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_content, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.recipe = recipes.get(position);
        holder.tvRecipeName.setText(recipes.get(position).getName());
        Glide.with(holder.mView.getContext())
                .load(recipes.get(holder.getAdapterPosition()).getImageURL())
                .into(holder.ivRecipeImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putInt(RecipeDetailFragment.ARG_POSITION, holder.getAdapterPosition());
//                    arguments.putSerializable(RecipeDetailFragment.ARG_STEP_ID, holder.recipe.getSteps().get(position));


                    RecipeDetailFragment fragment = new RecipeDetailFragment();
                    fragment.setArguments(arguments);

                    fragmentManager.beginTransaction()
                            .replace(R.id.recipe_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();

                    Intent intent = new Intent(context, RecipeDetailActivity.class);
                    intent.putExtra(RecipeDetailFragment.ARG_POSITION, holder.getAdapterPosition());

                    context.startActivity(intent);
                }
                Hawk.put(LAST_POS_CLICKED,position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setData(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView tvRecipeName;
        final ImageView ivRecipeImage ;
        Recipe recipe;

        ViewHolder(View view) {
            super(view);
            mView = view;
            tvRecipeName = (TextView) view.findViewById(R.id.content);
            ivRecipeImage = (ImageView) view.findViewById(R.id.recipe_image) ;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvRecipeName.getText() + "'";
        }
    }
}
