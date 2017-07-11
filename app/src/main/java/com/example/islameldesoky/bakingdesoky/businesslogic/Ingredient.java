package com.example.islameldesoky.bakingdesoky.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class Ingredient implements Serializable {

    @SerializedName("measure")
    @Expose
    private String measure;

    @SerializedName("quantity")
    @Expose
    private String quantity;

    @SerializedName("ingredient")
    @Expose
    private String ingredient;

    public String getMeasure() {
        return measure;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getIngredient() {
        return ingredient;
    }
}
