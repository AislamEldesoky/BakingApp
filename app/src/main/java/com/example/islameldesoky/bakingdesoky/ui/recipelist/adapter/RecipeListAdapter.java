package com.example.islameldesoky.bakingdesoky.ui.recipelist.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islameldesoky.bakingdesoky.R;
import com.example.islameldesoky.bakingdesoky.businesslogic.Recipe;

import java.util.List;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class RecipeListAdapter
        extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    private List<Recipe> recipes;
    private final boolean mTwoPane;
    private final FragmentManager fragmentManager;

    public RecipeListAdapter(List<Recipe> recipes, boolean mTwoPane, FragmentManager fragmentManager) {
        this.recipes = recipes;
        this.mTwoPane = mTwoPane;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = recipes.get(position);
        holder.mContentView.setText(recipes.get(position).getName());

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mTwoPane) {
//                    Bundle arguments = new Bundle();
//                    arguments.putString(RecipeDetailFragment.ARG_ITEM_ID, holder.mItem.getId());
//                    RecipeDetailFragment fragment = new RecipeDetailFragment();
//                    fragment.setArguments(arguments);
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.recipe_detail_container, fragment)
//                            .commit();
//                } else {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, RecipeDetailActivity.class);
//                    intent.putExtra(RecipeDetailFragment.ARG_ITEM_ID, holder.mItem.getId());
//
//                    context.startActivity(intent);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setData(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mContentView;
        Recipe mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
