package org.example.manager.deserializer;

import com.google.gson.*;
import org.example.manager.recources.LabWork;
import org.example.manager.recources.*;

import java.lang.reflect.Type;

public class LabWorkDeserializer implements JsonDeserializer<LabWork> {
    @Override
    public LabWork deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();

        LabWork labwork = new LabWork();
        if (jsonObject.has("name") && !jsonObject.get("name").isJsonNull()) {
            try {
                labwork.setName(jsonObject.get("name").getAsString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (jsonObject.has("coordinates") && !jsonObject.get("coordinates").isJsonNull()) {
            labwork.setCoordinates((Coordinates) context.deserialize(jsonObject.get("coordinates"), Coordinates.class));
        }
        if (jsonObject.has("minimalPoint") && !jsonObject.get("minimalPoint").isJsonNull()) {
            labwork.setMinimalPoint(jsonObject.get("minimalPoint").getAsDouble());
        }
        if (jsonObject.has("difficulty") && !jsonObject.get("difficulty").isJsonNull()) {
            labwork.setDifficulty((Difficulty) context.deserialize(jsonObject.get("difficulty"), Difficulty.class));
        }
        if (jsonObject.has("author") && !jsonObject.get("author").isJsonNull()) {
            labwork.setAuthor((Person) context.deserialize(jsonObject.get("author"), Person.class));
        }
        return labwork;
    }
}
