package com.example.shopapplication;

public class Goods {

    private String name;
    // Image name (Without extension)
    private String imageName;
    private int price;

    public Goods(String name, String imageName, int price) {
        this.name = name;
        this.imageName= imageName;
        this.price= price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String flagName) {
        this.imageName = imageName;
    }

    @Override
    public String toString()  {
        return this.name+" (Price: "+ this.price+")";
    }
}