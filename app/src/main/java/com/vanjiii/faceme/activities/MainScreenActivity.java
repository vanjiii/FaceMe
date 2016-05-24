package com.vanjiii.faceme.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.fragments.MainNavigationFragment;
import com.vanjiii.faceme.fragments.PreviewAllPhotosFragment;
import com.vanjiii.faceme.fragments.PreviewManipulatedPhotoFragment;
import com.vanjiii.faceme.fragments.SavePhotoFragment;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

public class MainScreenActivity extends AppCompatActivity implements OnFragmentItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
//        BaseApplication.getObjectGraph().inject(this);
        callMainNavigationFragment();
    }

    @Override
    public void callDatabaseViewerActivity() {
        Intent i = new Intent(this, AndroidDatabaseManager.class);
        this.startActivity(i);
    }

    @Override
    public void callMainNavigationFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_screen_placeholder, new MainNavigationFragment());
        ft.commit();
    }

    @Override
    public void callSavePhotoFragment(boolean isComingFromAdapter) {
        SavePhotoFragment fragment = new SavePhotoFragment();
        fragment.setIsComingFromAllPhotos(isComingFromAdapter);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_screen_placeholder, fragment);
        transaction.commit();
    }

    @Override
    public void callPreviewPhotoFragment(Uri uri) {
        PreviewManipulatedPhotoFragment fragment = new PreviewManipulatedPhotoFragment();
        fragment.setPhotoUri(uri);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_screen_placeholder, fragment);
        transaction.commit();
    }

    @Override
    public void callPreviewAllPhotosFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_screen_placeholder, new PreviewAllPhotosFragment());
        transaction.commit();
    }
}
