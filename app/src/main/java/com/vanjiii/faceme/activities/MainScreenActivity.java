package com.vanjiii.faceme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.applications.BaseApplication;

public class MainScreenActivity extends AppCompatActivity {

    private Button takePhotoButton;
    private Button previewAllPhotosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        BaseApplication.getObjectGraph().inject(this);

        initLayoutElements();
        setOnClickListeners();
    }

    private void initLayoutElements() {
        takePhotoButton = (Button) findViewById(R.id.take_photo_button);
        previewAllPhotosButton = (Button) findViewById(R.id.preview_taken_photos_button);
    }

    private void setOnClickListeners() {
        takePhotoButton.setOnClickListener(takePhotoListener);
        previewAllPhotosButton.setOnClickListener(previewPhotosListener);
    }

    private View.OnClickListener takePhotoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainScreenActivity.this, "Take photo", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener previewPhotosListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainScreenActivity.this, "Preview all photos", Toast.LENGTH_LONG).show();
        }
    };
}
