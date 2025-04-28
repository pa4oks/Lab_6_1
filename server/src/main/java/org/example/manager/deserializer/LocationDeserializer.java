package org.example.manager.deserializer;
import com.google.gson.*;
import org.example.manager.recources.LabWork;
import org.example.manager.recources.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class LocationDeserializer implements JsonDeserializer<Location> {
    @SerializedName("x")
    private long x;
    @SerializedName("y")
    private Integer y; //Поле не может быть null
    @SerializedName("z")
    private Float z; //Поле не может быть null
    @SerializedName("name")
    private String name; //Поле не может быть null

    @Override
    public Location deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();

        Location location = new Location();
        if (jsonObject.has("name") && !jsonObject.get("name").isJsonNull()) {
            location.setName(jsonObject.get("name").getAsString());
        }
        if (jsonObject.has("x") && !jsonObject.get("x").isJsonNull()) {
            location.setX(jsonObject.get("x").getAsLong());
        }
        if (jsonObject.has("y") && !jsonObject.get("y").isJsonNull()) {
            location.setY(jsonObject.get("y").getAsInt());
        }
        if (jsonObject.has("z") && !jsonObject.get("z").isJsonNull()) {
            location.setZ(jsonObject.get("z").getAsFloat());
        }
        return location;
    }
}