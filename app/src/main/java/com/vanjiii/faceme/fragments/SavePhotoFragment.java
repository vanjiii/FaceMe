package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.constants.DatabaseConstants;
import com.vanjiii.faceme.constants.GenderEnum;
import com.vanjiii.faceme.database.DatabaseAdapterImpl;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

/**
 * Fragment that shows the taken picture and gives the possibility to add info about the person.
 * <p/>
 * Created by vanjiii on 08.05.16.
 */
public class SavePhotoFragment extends Fragment {
    //TODO: Add logic to user be able to choose the algorithm with which the image will be processed. maybe on click on manipulated image...?
    //TODO: change button SAVE to SEND

    private ImageView initialImageView;
    private EditText personNameEditText;
    private EditText personAgeEditText;
    private Spinner sexSpinner;
    private Button confirmButton;
    private Button cancelButton;
    private OnFragmentItemSelectedListener callback;

    private boolean isComingFromAllPhotos = false;
    private Person personBean;

    View.OnClickListener confirmButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isComingFromAllPhotos) {
//                if (!personBean.isSentToServer().getValueBool()) {
                    sendPersonToServer();
//                }
            } else {
                savePersonToDB();
            }
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
        setElementsProperties();

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

    public Person getPictureUri() {
        return personBean;
    }

    public void setPictureUri(Person person) {
        this.personBean = person;
    }


    public void setIsComingFromAllPhotos(boolean isComingFromAllPhotos) {
        this.isComingFromAllPhotos = isComingFromAllPhotos;
    }

    private void initLayoutElements(View rootView) {
        initialImageView = (ImageView) rootView.findViewById(R.id.initial_image_view);
        personNameEditText = (EditText) rootView.findViewById(R.id.person_name_edit_text);
        personAgeEditText = (EditText) rootView.findViewById(R.id.person_age_edit_text);
        sexSpinner = (Spinner) rootView.findViewById(R.id.sex_spinner);
        cancelButton = (Button) rootView.findViewById(R.id.cancel_button);
        confirmButton = (Button) rootView.findViewById(R.id.save_button);
    }

    private void setOnClickListeners() {
        confirmButton.setOnClickListener(confirmButtonClickListener);
        cancelButton.setOnClickListener(resetPersonSavingListener);
    }

    private void setElementsProperties() {
        if (isComingFromAllPhotos) {
            confirmButton.setText("Send");
            if (personBean.isSentToServer().getValueBool()) {
                confirmButton.setEnabled(false);
            } else {
                confirmButton.setEnabled(true);
            }
            populatePersonAttributesToFragment();
        } else {
            confirmButton.setText("Save");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, GenderEnum.getAllGenders());
        sexSpinner.setAdapter(adapter);
    }

    private void populatePersonAttributesToFragment() {
        personAgeEditText.setText(String.valueOf(personBean.getAge()));
        personNameEditText.setText(personBean.getName());
        sexSpinner.setSelection(GenderEnum.getIndex(personBean.getSex()));
        //TODO: set initial image
        //TODO: set manipulated image
    }


    private void sendPersonToServer() {
        Toast.makeText(getContext(), "Send successful", Toast.LENGTH_SHORT).show();
        personBean.setIsSentToServer(DatabaseConstants.SENT);
        DatabaseAdapterImpl database = new DatabaseAdapterImpl(getContext());
        database.storePerson(personBean);

    }

    private void savePersonToDB() {
        //TODO: remove the mock
        Toast.makeText(getActivity(), "save it", Toast.LENGTH_SHORT).show();
        Person person = new Person();
        person.setName(personNameEditText.getText().toString());
        person.setAge(Integer.parseInt(personAgeEditText.getText().toString()));
        person.setIsSentToServer(DatabaseConstants.NOT_SENT);
        person.setPhotoUri("path-to-photo");
//            Log.i("faceme", pictureUri + "");
        person.setSex(GenderEnum.getGenderForValue(sexSpinner.getSelectedItem().toString()));


    }
}
