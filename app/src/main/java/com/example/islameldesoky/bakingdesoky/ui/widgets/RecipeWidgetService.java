package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Ingredient;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment;
import com.example.islameldesoky.bakingdesoky.utils.App;

import java.util.List;

/**
 * Created by islam eldesoky on 17/07/2017.
 */

public class RecipeWidgetService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new RecipeWidgetListFactory(this.getApplicationContext(), intent);
    }



    /**
     * Created by islam eldesoky on 17/07/2017.
     */

    public class RecipeWidgetListFactory implements RemoteViewsService.RemoteViewsFactory {
        public static final String ARG_POSITION = "position";
        Context mContext ;
        private Recipe recipe;
        private int position ;
        private Ingredient ingredient ;
        List<Ingredient> ingredients ;

        private List<Recipe> recipes ;

        public RecipeWidgetListFactory(Context applicationContext, Intent intent) {
            this.mContext = applicationContext;
        }

        @Override
        public void onCreate() {
            ingredients = App.getInstance().getIngredients();
        }

        @Override
        public void onDataSetChanged() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return ingredients.size();
        }

        @Override
        public RemoteViews getViewAt(int position) {

            recipes = App.getInstance().getRecipes();
            ingredients = App.getInstance().getIngredients();
            ingredient = App.getInstance().getIngredients().get(position);
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.recipe_widget_layout);
            views.setTextViewText(R.id.widget_ingredient ,ingredients.get(position).getIngredient());
            views.setTextViewText(R.id.widget_quantity,ingredients.get(position).getQuantity());
            views.setTextViewText(R.id.widget_measure,ingredients.get(position).getMeasure());
            Intent fillInIntent = new Intent();
            fillInIntent.setAction(RecipeWidgetProvider.ACTION_TOAST);
            Bundle extras = new Bundle();
            extras.putString(RecipeDetailFragment.ARG_POSITION,ingredients.get(position).getIngredient());

            fillInIntent.putExtras(extras);
            views.setOnClickFillInIntent(R.id.widget_ingredient, fillInIntent);
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
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}