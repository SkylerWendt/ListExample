package com.example.wendt.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private TextView profileNameTextView, profileDescriptionTextView;
    private ImageView profileImageView;
    private String name, description;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getIntents();
        wireWidgets();
        setIntents();
    }

    private void wireWidgets() {
        profileNameTextView = (TextView) findViewById(R.id.text_name);
        profileDescriptionTextView = (TextView) findViewById(R.id.text_description);
        profileImageView = (ImageView) findViewById(R.id.image_profile);
    }

    private void getIntents() {
        Intent toughieProfile = getIntent();
        name = toughieProfile.getStringExtra(MainActivity.EXTRA_NAME);
        description = toughieProfile.getStringExtra(MainActivity.EXTRA_DESCRIPTION);
        //image = toughieProfile.getIntExtra(MainActivity.EXTRA_IMAGE);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void setIntents(){
        profileNameTextView.setText(name);
        profileDescriptionTextView.setText(description);
        //profileImageView.setImageResource(image);
    }
}
