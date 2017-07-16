package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment;

import java.util.ArrayList;

/**
 * Created by islam eldesoky on 16/07/2017.
 */

public class RecipeListViewFactory implements RemoteViewsService.RemoteViewsFactory {
    private ArrayList<Recipe> recipes ;
    Context mContext ;
    public RecipeListViewFactory(Context applicationContext ){
        this.mContext = applicationContext ;
    }
    @Override
    public void onCreate() {

        recipes = new ArrayList<Recipe>();


    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews views = new RemoteViews(mContext.getPackageName(),R.layout.widget_item) ;
        views.setTextViewText(R.id.item,recipes.get(position).getName());
        Bundle extras = new Bundle();
        extras.putLong(RecipeDetailFragment.ARG_POSITION, position);
        Intent fillInIntent = new Intent();
        fillInIntent.putExtras(extras);
        views.setOnClickFillInIntent(R.id.item, fillInIntent);
        return views ;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
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
