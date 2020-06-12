package com.hfad.post_example2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class user_image_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_image_view);

        ImageView imageView = findViewById(R.id.bitmap_image);
        imageView.setImageURI(UriHelper.getInstance().getUri());
    }
}
