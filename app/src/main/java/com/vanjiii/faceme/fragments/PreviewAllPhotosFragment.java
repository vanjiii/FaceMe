package com.vanjiii.faceme.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.adapters.PreviewAllPhotosArrayAdapter;
import com.vanjiii.faceme.beans.Person;
import com.vanjiii.faceme.interfaces.OnFragmentItemSelectedListener;

import java.util.List;

/**
 * Fragment that shows all of the taken photos
 * <p>
 * Created by vanjiii on 08.05.16.
 */
public class PreviewAllPhotosFragment extends Fragment {

    private Button sendAllButton;
    private ListView rowListView;

    private OnFragmentItemSelectedListener callback;

    private View.OnClickListener sendAllPicturesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Send All pictures", Toast.LENGTH_LONG).show();
        }
    };

    private AdapterView.OnItemClickListener photoClickedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            callback.callSavePhotoFragment();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.preview_all_photos_fragment, parent, false);

        initLayoutElements(rootView);
        setOnClickListeners();
        populateRow();

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

    private void initLayoutElements(View view) {
        sendAllButton = (Button) view.findViewById(R.id.send_all_pictures_button);
        rowListView = (ListView) view.findViewById(R.id.picture_row_list_view);
    }

    private void setOnClickListeners() {
        sendAllButton.setOnClickListener(sendAllPicturesListener);
        rowListView.setOnItemClickListener(photoClickedListener);
    }

    private void populateRow() {
        // Construct the data source
        List<Person> arrayOfUsers = Person.getAllPersons();
        // Create the adapter to convert the array to views
        PreviewAllPhotosArrayAdapter adapter = new PreviewAllPhotosArrayAdapter(getContext(), arrayOfUsers);
        // Attach the adapter to a ListView
        rowListView.setAdapter(adapter);
    }
}
