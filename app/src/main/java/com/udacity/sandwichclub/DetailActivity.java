package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private ImageView ingredientsIv;
    private TextView mName;
    private TextView mDescription;
    private TextView mPlace;
    private TextView mAka;
    private TextView mIngredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ingredientsIv = findViewById(R.id.image_iv);
        mName = findViewById(R.id.mainName);
        mAka = findViewById(R.id.also_known_tv);
        mPlace = findViewById(R.id.origin_tv);
        mDescription = findViewById(R.id.description_tv);
        mIngredients = findViewById(R.id.ingredients_tv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = null;
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (sandwich == null) {
            // Sandwich data unavailable
            Log.d("Test", json);
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        //Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();

    }

    private void populateUI(Sandwich sandwich) {
        mName.setText(sandwich.getMainName());
        mAka.setText(sandwich.getAkaString());
        mPlace.setText(sandwich.getPlaceOfOrigin());
        mDescription.setText(sandwich.getDescription());
        mIngredients.setText(sandwich.getIngredientsString());
    }
}
