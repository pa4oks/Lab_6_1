package org.example.manager.deserializer;

import com.google.gson.*;
import org.example.manager.recources.*;

import java.lang.reflect.Type;

public class CoordinatesDeserializer implements JsonDeserializer<Coordinates> {
    @Override
    public Coordinates deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();

        Coordinates coordinates = new Coordinates();
        if (jsonObject.has("coordinatesX") && !jsonObject.get("coordinatesX").isJsonNull()) {
            try {
                coordinates.setX(jsonObject.get("coordinatesX").getAsFloat());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (jsonObject.has("coordinatesY") && !jsonObject.get("coordinatesY").isJsonNull()) {
            coordinates.setY(jsonObject.get("coordinatesY").getAsLong());
        }
        return coordinates;
    }
}