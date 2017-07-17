package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.content.Intent;
import android.widget.RemoteViewsService;

import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;

import java.util.List;

/**
 * Created by islam eldesoky on 17/07/2017.
 */

public class RecipeWidgetService extends RemoteViewsService {
    private List<Recipe> recipes ;
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new RecipeWidgetListFactory(this.getApplicationContext());
    }
}
