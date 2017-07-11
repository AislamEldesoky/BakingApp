package com.example.islameldesoky.bakingdesoky.ui.recipedetails.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Ingredient;

import java.util.List;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder> {

    private List<Ingredient> ingredients;

    public IngredientListAdapter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public IngredientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_ingredient, parent, false);
        return new IngredientListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientListAdapter.ViewHolder holder, int position) {
        holder.mItem = ingredients.get(position);
        holder.mMeasure.setText(ingredients.get(position).getMeasure());
        holder.mIngredient.setText(ingredients.get(position).getIngredient());
        holder.mQuantity.setText(ingredients.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIngredient;
        final TextView mMeasure;
        final TextView mQuantity;
        Ingredient mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIngredient = (TextView) view.findViewById(R.id.tv_ingredient_name);
            mMeasure = (TextView) view.findViewById(R.id.tv_ingredient_measure);
            mQuantity = (TextView) view.findViewById(R.id.tv_ingredient_quantity);
        }
    }
}

