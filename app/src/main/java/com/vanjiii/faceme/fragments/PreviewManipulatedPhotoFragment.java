package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.faces.FaceDetectorAdapter;
import com.vanjiii.faceme.faces.FaceDetectorAdapterImpl;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

import java.io.File;

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
    private Button manipulatePhotoButton;

    private Uri uri;
    private OnFragmentItemSelectedListener callback;

    private View.OnClickListener confirmButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Person person = new Person();
            person.setInitialPhotoUri(uri.toString());
            callback.callSavePhotoFragment(false, person);
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

    private View.OnClickListener manipulatePhotoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FaceDetectorAdapter faceDetector = new FaceDetectorAdapterImpl();
            Bitmap manipulatedBitmapImage = faceDetector.findFace(uri, getContext());

            if (manipulatedBitmapImage != null) {
                manipulatedImageView.setImageBitmap(manipulatedBitmapImage);
            } else {
                Toast.makeText(getActivity(), "face not found", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_manipulated_photo_fragment, parent, false);

        initLayoutElements(rootView);
        setOnClickListeners();
        originalPhotoImageView.setImageURI(uri);
//
//
//        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File imageFile = new File(path.getAbsolutePath() + File.separator + "kor" + File.separator + "1.jpg");
//        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
//        originalPhotoImageView.setImageBitmap(bitmap);
//
//

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
        manipulatePhotoButton = (Button) view.findViewById(R.id.manipulate_photo_button);
    }

    private void setOnClickListeners() {
        confirmButton.setOnClickListener(confirmButtonListener);
        declineButton.setOnClickListener(declineButtonListener);
        manipulatePhotoButton.setOnClickListener(manipulatePhotoListener);
    }
}
