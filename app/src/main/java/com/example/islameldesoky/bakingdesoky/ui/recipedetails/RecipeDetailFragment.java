package com.example.islameldesoky.bakingdesoky.ui.recipedetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;
import com.example.islameldesoky.bakingdesoky.ui.RecipeSteps.RecipeStepsActivity;
import com.example.islameldesoky.bakingdesoky.ui.recipedetails.adapter.IngredientListAdapter;
import com.example.islameldesoky.bakingdesoky.utils.App;
import com.orhanobut.hawk.Hawk;

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_POSITION = "position";
    public static final String EXTRA_APPWIDGET_ID = "recipes";

    private IngredientListAdapter ingredientListAdapter;
    private RecyclerView rvIngredients;
    private int position;
    private Recipe recipe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments() == null ?
                getActivity().getIntent().getIntExtra(ARG_POSITION, 1) :
                getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        if (Hawk.get(App.ARG_RECIPES) != null) {
            recipe = App.getInstance().getRecipes().get(position);

            ((TextView) rootView.findViewById(R.id.tv_recipe_name)).setText(recipe.getName());

            rvIngredients = (RecyclerView) rootView.findViewById(R.id.rv_ingredients);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(rootView.getContext(),
                    LinearLayoutManager.VERTICAL,
                    false);
            rvIngredients.setLayoutManager(manager);

            ingredientListAdapter = new IngredientListAdapter(recipe.getIngredients());
            rvIngredients.setAdapter(ingredientListAdapter);
        }

        rootView.findViewById(R.id.view_steps).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), RecipeStepsActivity.class);
        intent.putExtra(ARG_POSITION, position);
        startActivity(intent);
    }
}
