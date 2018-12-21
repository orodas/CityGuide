package com.robotemplates.cityguide;

/**
 * Created by oscar on 7/26/2017.
 */

public class Friend {
    int id;
    String uname, fruname, image;

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

    public String getUname() //username of the user who has this person as a friend
    {
        return this.uname;
    }

    public void setFruname(String fruname)
    {
        this.fruname = fruname;
    }

    public String getFruname() //username of this person
    {
        return this.fruname;
    }

    public void setImage(String imagee)
    {
        this.image = image;
    }

    public String getImage()
    {
        return this.image;
    }
}
