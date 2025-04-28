package org.example.manager.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.manager.recources.*;


import java.lang.reflect.Type;

public class CountryDeserializer implements JsonDeserializer<Country> {
    @Override
    public Country deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String countryString = json.getAsString();
        return Country.valueOf(countryString);

    }
}
