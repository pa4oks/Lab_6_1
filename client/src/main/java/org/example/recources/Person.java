package org.example.recources;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @SerializedName("weight")
    private int weight; //Значение поля должно быть больше 0
    @SerializedName("eyeColor")
    private Color eyeColor; //Поле не может быть null
    @SerializedName("hairColor")
    private Color hairColor; //Поле может быть null
    @SerializedName("nationality")
    private Country nationality; //Поле может быть null
    @SerializedName("location")
    private Location location; //Поле может быть null



    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if (name==null) {
            throw new IllegalAccessException("name");
        }
        else{
            this.name = name;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalAccessException {
        if (weight<0) {
            throw new IllegalAccessException("name");
        }
        else{
            this.weight = weight;
        }
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
