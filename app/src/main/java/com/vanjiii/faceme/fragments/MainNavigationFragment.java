package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;
import com.vanjiii.faceme.managers.CameraManager;

/**
 * Main fragment which hold basic navigation links.
 * <p>
 * Created by vanjiii on 07.05.16.
 */
public class MainNavigationFragment extends Fragment {

    private Button takePhotoButton;
    private Button previewAllPhotosButton;
    private Button dbViewerButton;
    private Uri uri;
    private OnFragmentItemSelectedListener callback;

    private View.OnClickListener takePhotoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: Why can't I pass 'uri' as argument to "CameraManager.startCamera()' ??
            uri = CameraManager.startCamera(getActivity());
        }
    };

    private View.OnClickListener previewPhotosListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callback.callPreviewAllPhotosFragment();
        }
    };

    private View.OnClickListener dbViewerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callback.callDatabaseViewerActivity();
        }
    };

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View rootView = inflater.inflate(R.layout.main_navigation_fragment, parent, false);


        initLayoutElements(rootView);
        setOnClickListeners();

        return rootView;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraManager.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == FragmentActivity.RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
//                Toast.makeText(this, "Image saved to:\n" +
//                        data.getData(), Toast.LENGTH_LONG).show();

                //TODO: Why data is null??
                //TODO: fix msg
                //TODO Add logging.
                callback.callSavePhotoFragment(uri);
            } else if (resultCode == FragmentActivity.RESULT_CANCELED) {
                // User cancelled the image capture
                //TODO: add msg and flow
            } else {
                // Image capture failed, advise user
                //TODO: add msg and flow
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (OnFragmentItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentItemSelectedListener!");
        }
    }

    private void initLayoutElements(View view) {
        takePhotoButton = (Button) view.findViewById(R.id.take_photo_button);
        previewAllPhotosButton = (Button) view.findViewById(R.id.preview_taken_photos_button);
        dbViewerButton = (Button) view.findViewById(R.id.db_viewer_button);
    }

    private void setOnClickListeners() {
        takePhotoButton.setOnClickListener(takePhotoListener);
        previewAllPhotosButton.setOnClickListener(previewPhotosListener);
        dbViewerButton.setOnClickListener(dbViewerListener);
    }
}
