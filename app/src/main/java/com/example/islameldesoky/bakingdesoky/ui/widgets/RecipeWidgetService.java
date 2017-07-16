package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by islam eldesoky on 16/07/2017.
 */

public class RecipeWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return (new RecipeListViewFactory(this.getApplicationContext()));
    }
}
