package com.vanjiii.faceme.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.applications.BaseApplication;
import com.vanjiii.faceme.managers.CameraManager;

public class MainScreenActivity extends AppCompatActivity {

    private Button takePhotoButton;
    private Button previewAllPhotosButton;
    private Button dbViewerButton;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        BaseApplication.getObjectGraph().inject(this);

        initLayoutElements();
        setOnClickListeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraManager.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
//                Toast.makeText(this, "Image saved to:\n" +
//                        data.getData(), Toast.LENGTH_LONG).show();

                //TODO: Why data is null??
                //TODO: fix msg
                //TODO Add logging.

                //TODO: Add fragment to show current current picture.

            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
                //TODO: add msg and flow
            } else {
                // Image capture failed, advise user
                //TODO: add msg and flow
            }
        }
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
            //TODO: Why can't I pass 'uri' as argument to "CameraManager.startCamera()' ??
            uri = CameraManager.startCamera(MainScreenActivity.this);
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
