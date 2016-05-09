package com.vanjiii.faceme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vanjiii.faceme.R;

/**
 * Fragment that shows all of the taken photos
 *
 * Created by vanjiii on 08.05.16.
 */
public class PreviewAllPhotosFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.preview_all_photos_fragment, parent, false);
//
//        initLayoutElements(rootView);
//        setOnClickListeners();

        return rootView;
    }
}
