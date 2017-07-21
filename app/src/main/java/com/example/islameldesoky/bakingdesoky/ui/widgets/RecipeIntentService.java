package com.example.islameldesoky.bakingdesoky.ui.widgets;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.islameldesoky.bakingdesoky.businesslogic.Ingredient;

import java.util.ArrayList;

/**
 * Created by islam eldesoky on 21/07/2017.
 */

public class RecipeIntentService extends IntentService {

    public static String INGREDIENT_LIST = "INGREDIENT_LIST" ;


    public RecipeIntentService() {
        super("RecipeIntentService");
    }

        public static void StartService(Context context , ArrayList<Ingredient> mIngredientList){
            Intent intent = new Intent(context,RecipeIntentService.class);
            intent.putExtra(INGREDIENT_LIST , mIngredientList);
            context.startService(intent);
        }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent!=null){
            ArrayList<String> mIngredientList = intent.getExtras().getStringArrayList(INGREDIENT_LIST);
            HandleActions(mIngredientList);
        }

    }

    private void HandleActions(ArrayList<String> mIngredientList){
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE2") ;
        intent.setAction("aandroid.appwidget.action.APPWIDGET_UPDATE2") ;
        intent.putExtra(INGREDIENT_LIST,mIngredientList);
        sendBroadcast(intent);
    }
}
