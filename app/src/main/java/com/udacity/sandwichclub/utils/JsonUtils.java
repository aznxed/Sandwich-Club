package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichJson = new JSONObject(json);
        JSONObject names = sandwichJson.getJSONObject("name");
        String mainName = names.getString("mainName");
        JSONArray alsoKnownAs = names.getJSONArray("alsoKnownAs");

        ArrayList<String> altNames = new ArrayList<String>();
        if (alsoKnownAs != null) {
            int len = alsoKnownAs.length();
            for (int i=0;i<len;i++){
                altNames.add(alsoKnownAs.get(i).toString());
            }

        }

        String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
        String description = sandwichJson.getString("description");
        String imgURL = sandwichJson.getString("image");

        JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
        ArrayList<String> listIngredients = new ArrayList<String>();
        if (ingredients != null) {
            int len = ingredients.length();
            for (int i=0;i<len;i++){
                listIngredients.add(ingredients.get(i).toString());
            }
        }

        Sandwich sandwich = new Sandwich(mainName, altNames, placeOfOrigin, description, imgURL, listIngredients);
        return sandwich;
    }
}
