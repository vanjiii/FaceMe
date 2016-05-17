package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

/**
 * Fragment that shows the taken picture and gives the possibility to add info about the person.
 * <p/>
 * Created by vanjiii on 08.05.16.
 */
public class SavePhotoFragment extends Fragment {
    //TODO: Add logic to user be able to choose the algorithm with which the image will be processed. maybe on click on manipulated image...?
    //TODO: change button SAVE to SEND

    private Uri pictureUri;
    //TODO: Make upper hint disappear after image is clicked.
    private ImageView initialImageView;
    private EditText personNameEditText;
    private EditText personAgeEditText;
    //TODO: Implement spinner.
    private Button saveButton;
    private Button cancelButton;

    //    private boolean isComingFrom
    private OnFragmentItemSelectedListener callback;

    View.OnClickListener savePersonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: create person bean and save it to DB.
            Toast.makeText(getActivity(), "save it", Toast.LENGTH_SHORT).show();
            callback.callMainNavigationFragment();
        }
    };

    View.OnClickListener resetPersonSavingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: destroy original, manipulated image, bean and record.
            callback.callMainNavigationFragment();
        }
    };

    public SavePhotoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.save_photo_fragment, parent, false);

        initLayoutElements(rootView);
        setOnClickListeners();

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


    public Uri getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(Uri pictureUri) {
        this.pictureUri = pictureUri;
    }

    private void initLayoutElements(View rootView) {
        initialImageView = (ImageView) rootView.findViewById(R.id.initial_image_view);
        personNameEditText = (EditText) rootView.findViewById(R.id.person_name_edit_text);
        personAgeEditText = (EditText) rootView.findViewById(R.id.person_age_edit_text);
        saveButton = (Button) rootView.findViewById(R.id.save_button);
        cancelButton = (Button) rootView.findViewById(R.id.cancel_button);
    }

    private void setOnClickListeners() {
        saveButton.setOnClickListener(savePersonClickListener);
        cancelButton.setOnClickListener(resetPersonSavingListener);
    }
}
