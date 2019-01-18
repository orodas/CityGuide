package com.example.oscarrodas.cityguide;

public class Location {
    int id;
    String name, description, category, intro, image, link, address, phone;
    //boolean favorite;

    public Location() {
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getCategory()
    {
        return category;
    }


    public void setCategory(String category)
    {
        this.category = category;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getIntro()
    {
        return intro;
    }


    public void setIntro(String intro)
    {
        this.intro = intro;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getImage()
    {
        return image;
    }


    public void setImage(String image)
    {
        this.image = image;
    }


    public String getLink()
    {
        return link;
    }


    public void setLink(String link)
    {
        this.link = link;
    }

    public String getAddress()
    {
        return address;
    }


    public void setAddress(String address)
    {
        this.address = address;
    }


    public String getPhone()
    {
        return phone;
    }


    public void setPhone(String phone)
    {
        this.phone = phone;
    }


    /*public boolean isFavorite()
    {
        return favorite;
    }


    public void setFavorite(boolean favorite)
    {
        this.favorite = favorite;
    }*/
}
