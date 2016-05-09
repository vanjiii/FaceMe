package com.vanjiii.faceme.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanjiii.faceme.R;

/**
 * Fragment that shows the taken picture and gives the possibility to add info about the person.
 * <p>
 * Created by vanjiii on 08.05.16.
 */
public class SavePhotoFragment extends Fragment {
    //TODO: Add logic to user be able to choose the algorithm with which the image will be processed. maybe on click on manipulated image...?

    private Uri pictureUri;
    //TODO: Make upper hint disappear after image is clicked.
    private TextView hintLabelTextView;
    private ImageView initialImageView;
    private ImageView manipulatedImageView;
    private EditText personNameEditText;
    private EditText personAgeEditText;
    //TODO: Implement spinner.
    private Button saveButton;
    private Button cancelButton;


    public SavePhotoFragment() {
    }

    public Uri getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(Uri pictureUri) {
        this.pictureUri = pictureUri;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.save_photo_fragment, parent, false);

        initLayoutElements(rootView);
        setOnClickListeners();

        return rootView;
    }

    private void initLayoutElements(View rootView) {
        hintLabelTextView = (TextView) rootView.findViewById(R.id.hint_label_text_view);
        initialImageView = (ImageView) rootView.findViewById(R.id.initial_image_view);
        manipulatedImageView = (ImageView) rootView.findViewById(R.id.manipulated_image_view);
        personNameEditText = (EditText) rootView.findViewById(R.id.person_name_edit_text);
        personAgeEditText = (EditText) rootView.findViewById(R.id.person_age_edit_text);
        saveButton = (Button) rootView.findViewById(R.id.save_button);
        cancelButton = (Button) rootView.findViewById(R.id.cancel_button);
    }

    private void setOnClickListeners() {
        saveButton.setOnClickListener(savePersonClickListener);
        cancelButton.setOnClickListener(resetPersonSavingListener);
        initialImageView.setOnClickListener(initialImageListener);
    }

    View.OnClickListener savePersonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: create person bean and save it to DB.
        }
    };

    View.OnClickListener resetPersonSavingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: Logic to implement..? Maybe reset fields and/or destroy fragment.
        }
    };

    View.OnClickListener initialImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: call the face algorithm and display the result in the other imageView.
        }
    };
}
