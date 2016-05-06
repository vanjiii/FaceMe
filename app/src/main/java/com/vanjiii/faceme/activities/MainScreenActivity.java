package com.vanjiii.faceme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.applications.BaseApplication;
import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.constants.GenderEnum;
import com.vanjiii.faceme.database.DatabaseAdapterImpl;

public class MainScreenActivity extends AppCompatActivity {

    private Button takePhotoButton;
    private Button previewAllPhotosButton;
    private Button dbViewerButton;

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
        dbViewerButton = (Button) findViewById(R.id.db_viewer_button);
    }

    private void setOnClickListeners() {
        takePhotoButton.setOnClickListener(takePhotoListener);
        previewAllPhotosButton.setOnClickListener(previewPhotosListener);
        dbViewerButton.setOnClickListener(dbViewerListener);
    }

    private View.OnClickListener takePhotoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Person person  = new Person();
            person.setPictureUri("uri");
            person.setName("name: " + Long.toHexString(Double.doubleToLongBits(Math.random())));
            person.setSex(GenderEnum.FEMALE);
            person.setAge(2);

            DatabaseAdapterImpl db = new DatabaseAdapterImpl(MainScreenActivity.this);
            db.storePerson(person);
            person.setPictureUri("url");
            person.setName("name: " + Long.toHexString(Double.doubleToLongBits(Math.random())));
            person.setSex(GenderEnum.MALE);
            person.setAge(19);
            db.storePerson(person);
            Toast.makeText(MainScreenActivity.this, "Person saved!", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener previewPhotosListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainScreenActivity.this, "Boo hoo...", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener dbViewerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainScreenActivity.this, AndroidDatabaseManager.class);
            MainScreenActivity.this.startActivity(i);
        }
    };
}
