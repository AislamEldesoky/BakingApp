package com.example.islameldesoky.bakingdesoky.ui.recipedetails;

import android.content.Intent;
import android.os.Bundle;
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

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_ITEM_ID = "item_id";

    private IngredientListAdapter ingredientListAdapter;
    private RecyclerView rvIngredients;
    private Bundle mBundle;
    private Recipe recipe;

    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments() == null ? getActivity().getIntent().getExtras() : getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        if (mBundle != null) {
            recipe = (Recipe) mBundle.getSerializable(RecipeDetailFragment.ARG_ITEM_ID);

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
        intent.putExtra(ARG_ITEM_ID, recipe);
        startActivity(intent);
    }
}
