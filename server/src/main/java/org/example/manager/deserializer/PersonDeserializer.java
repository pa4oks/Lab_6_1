package org.example.manager.deserializer;

import com.google.gson.*;
import org.example.manager.recources.LabWork;
import org.example.manager.recources.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class PersonDeserializer implements JsonDeserializer<Person> {
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

    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        Person person = new Person();

        if (jsonObject.has("name") && !jsonObject.get("name").isJsonNull()) {
            try {
                person.setName(jsonObject.get("name").getAsString());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (jsonObject.has("weight") && !jsonObject.get("weight").isJsonNull()) {
            try {
                person.setWeight(jsonObject.get("weight").getAsInt());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (jsonObject.has("eyeColor") && !jsonObject.get("eyeColor").isJsonNull()) {
            person.setEyeColor((Color) context.deserialize(jsonObject.get("eyeColor"), Color.class));
        }
        if (jsonObject.has("hairColor") && !jsonObject.get("hairColor").isJsonNull()) {
            person.setHairColor((Color) context.deserialize(jsonObject.get("hairColor"), Color.class));
        }
        if (jsonObject.has("nationality") && !jsonObject.get("nationality").isJsonNull()) {
            person.setNationality((Country) context.deserialize(jsonObject.get("nationality"), Country.class));
        }
        if (jsonObject.has("location") && !jsonObject.get("location").isJsonNull()) {
            person.setLocation((Location) context.deserialize(jsonObject.get("location"), Location.class));
        }
        return person;
    }
}

