package com.example.islameldesoky.bakingdesoky.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 10/07/2017.
 */

public class Steps implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;



    @SerializedName("shortDescription")
    @Expose
    private String ShortDescription;

    @SerializedName("description")
    @Expose
    private String Description;

    @SerializedName("videoURL")
    @Expose
    private String videoURL;

    @SerializedName("thumbnailURL")
    @Expose
    private String ThumbnailURL;

    public String getId() {
        return id;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public String getDescription() {
        return Description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return ThumbnailURL;
    }
}
