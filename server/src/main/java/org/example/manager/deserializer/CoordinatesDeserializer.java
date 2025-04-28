package org.example.manager.deserializer;

import com.google.gson.annotations.SerializedName;

public class CoordinatesDeserializer {
    @SerializedName("x")
    private float x=0; //Значение поля должно быть больше -204
    @SerializedName("y")
    private float y=0;

    public float getX() {
        return x;
    }

    public void setX(float x) throws IllegalAccessException{
        if (x<=-204) {
            throw new IllegalAccessException("name");
        }
        else{
            this.x = x;
        }
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public String getLocation() {
        return x + "_" + y;
    }
}
