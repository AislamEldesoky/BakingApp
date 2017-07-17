package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.RecipeDetailFragment;
import com.example.islameldesoky.bakingdesoky.utils.App;

/**
 * Created by islam eldesoky on 17/07/2017.
 */

public class RecipeWidgetProvider extends AppWidgetProvider {
    private int position ;
    private Recipe recipe;
    public RecipeWidgetProvider() {
        super();


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        recipe = App.getInstance().getRecipes().get(position) ;

        for (int widgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.recipe_widget_list);
            //views.setTextViewText(R.id.widget_recipe ,String.valueOf(recipe.getName()));
            Intent intent = new Intent(context, RecipeWidgetService.class);
            views.setRemoteAdapter(
                    R.id.widget_list_view,
                    intent);
            intent.putExtra(appWidgetManager.EXTRA_APPWIDGET_ID ,widgetId) ;

            intent = new Intent(context, RecipeDetailFragment.class);
            intent.putExtra(RecipeDetailFragment.ARG_POSITION, recipe.getName()) ;
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context , 0 ,intent , PendingIntent.FLAG_UPDATE_CURRENT) ;
            views.setOnClickPendingIntent(R.id.widget_recipe,pendingIntent);
            appWidgetManager.updateAppWidget(widgetId,views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}
