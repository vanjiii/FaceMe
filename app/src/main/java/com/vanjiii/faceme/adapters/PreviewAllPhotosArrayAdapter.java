package com.vanjiii.faceme.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.vanjiii.faceme.beans.Person;

import java.util.ArrayList;

/**
 * Created by vanjiii on 08.05.16.
 */
public class PreviewAllPhotosArrayAdapter extends ArrayAdapter<Person> {

    public PreviewAllPhotosArrayAdapter(Context context, ArrayList<Person> persons) {
        super(context, -1, persons);
    }
}
