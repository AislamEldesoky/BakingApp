package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment;
import com.example.islameldesoky.bakingdesoky.utils.App;

import java.util.List;

/**
 * Created by islam eldesoky on 17/07/2017.
 */

public class RecipeWidgetListFactory implements RemoteViewsService.RemoteViewsFactory {
    public static final String ARG_POSITION = "position";
    Context mContext ;
    private Recipe recipe;
    private int position ;
    private List<Recipe> recipes ;

    public RecipeWidgetListFactory(Context applicationContext) {
        this.mContext = applicationContext;
    }

    @Override
    public void onCreate() {

        recipes =App.getInstance().getRecipes();
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {

        recipe = App.getInstance().getRecipes().get(position);
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.recipe_widget_layout);
        views.setTextViewText(R.id.widget_recipe ,String.valueOf(recipe.getIngredients().get(position).getIngredient()));
        Intent fillInIntent = new Intent();
        fillInIntent.setAction(RecipeWidgetProvider.ACTION_TOAST);
        Bundle extras = new Bundle();
        extras.putString(RecipeDetailFragment.ARG_POSITION, recipe.getIngredients().get(position).getIngredient());

        fillInIntent.putExtras(extras);
        views.setOnClickFillInIntent(R.id.widget_recipe, fillInIntent);
        return views ;

    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
