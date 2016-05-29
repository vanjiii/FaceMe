package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.faces.FaceDetectorAdapter;
import com.vanjiii.faceme.faces.FaceDetectorAdapterImpl;
import com.vanjiii.faceme.faces.ImageManipulator;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

import java.io.File;
import java.io.IOException;

/**
 * Fragment which shows the taken photo and the manipulated one.
 * <p>
 * Created by vanjiii on 16.05.16.
 */
public class PreviewManipulatedPhotoFragment extends Fragment {

    private ImageView originalPhotoImageView;
    private ImageView manipulatedImageView;
    private Button confirmButton;
    private Button declineButton;

    private Uri uri;
    private OnFragmentItemSelectedListener callback;

    private View.OnClickListener confirmButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FaceDetectorAdapter faceDetector = new FaceDetectorAdapterImpl();
            Bitmap manipulatedImageUri = faceDetector.findFace(uri, getContext());

            if (manipulatedImageUri != null) {
                manipulatedImageView.setImageBitmap(manipulatedImageUri);
            }
            Toast.makeText(getActivity(), "face not found", Toast.LENGTH_SHORT).show();

//            Bitmap grayscale = null;
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
//                Log.d("FaceDetector", "colored width: " + bitmap.getWidth());
//                Log.d("FaceDetector", "colored width: " + bitmap.getHeight());
//                grayscale = ImageManipulator.convertToGrayscale(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Bitmap r = FaceDetectorAdapterImpl.compressPhoto(grayscale);
//            Log.d("FaceDetector", "compressPhoto width: " + r.getWidth());
//            Log.d("FaceDetector", "compressPhoto width: " + r.getHeight());
//            manipulatedImageView.setImageBitmap(r);
//


        }
    };

    private View.OnClickListener declineButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "decline", Toast.LENGTH_LONG).show();
            //TODO: destroy the two images
            callback.callMainNavigationFragment();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_manipulated_photo_fragment, parent, false);

        initLayoutElements(rootView);
        setOnClickListeners();
        originalPhotoImageView.setImageURI(uri);

        return rootView;
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

    public void setPhotoUri(Uri uri) {
        this.uri = uri;
    }

    private void initLayoutElements(View view) {
        originalPhotoImageView = (ImageView) view.findViewById(R.id.original_photo_image_view);
        manipulatedImageView = (ImageView) view.findViewById(R.id.manipulated_photo_image_view);
        confirmButton = (Button) view.findViewById(R.id.accept_button);
        declineButton = (Button) view.findViewById(R.id.decline_button);
    }

    private void setOnClickListeners() {
        confirmButton.setOnClickListener(confirmButtonListener);
        declineButton.setOnClickListener(declineButtonListener);
    }
}
