package com.robotemplates.cityguide;

/**
 * Created by oscar on 7/16/2017.
 */

public class Review {
    int id;
    String poiname,review,uname, r;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return this.uname;
    }

    public void setPoiname(String poiname)
    {
        this.poiname = poiname;
    }

    public String getPoiname()
    {
        return this.poiname;
    }

    public void setReview(String review)
    {
        this.review = review;
    }

    public String getReview()
    {
        return this.review;
    }

    public void setRating(String r){ this.r = r;}

    public String getRating() {return this.r;}
}
