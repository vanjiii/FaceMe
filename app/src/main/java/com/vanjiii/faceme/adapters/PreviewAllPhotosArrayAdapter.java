package com.vanjiii.faceme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vanjiii.faceme.R;
import com.vanjiii.faceme.beans.Person;

import java.util.List;

/**
 * Adapter visualizing all persons.
 *
 * Created by vanjiii on 08.05.16.
 */
public class PreviewAllPhotosArrayAdapter extends ArrayAdapter<Person> {

    public PreviewAllPhotosArrayAdapter(Context context, List<Person> persons) {
        super(context, -1, persons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Person person = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.person_picture_row, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.person_name_row_element_text_view);
            viewHolder.age = (TextView) convertView.findViewById(R.id.person_age_row_element_text_view);
            viewHolder.isSentToServer = (CheckBox) convertView.findViewById(R.id.is_sent_to_server_checkBox);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Lookup view for data population
//        TextView name = (TextView) convertView.findViewById(R.id.person_name_row_element_text_view);
//        TextView age = (TextView) convertView.findViewById(R.id.person_age_row_element_text_view);
        // Populate the data into the template view using the data object
        viewHolder.name.setText(person.getName());
        viewHolder.age.setText(String.valueOf(person.getAge()));
        viewHolder.isSentToServer.setChecked(person.isSentToServer().getValueBool());

        // Return the completed view to render on screen
        return convertView;
    }

    public static class ViewHolder {
        TextView name;
        TextView age;
        CheckBox isSentToServer;
    }
}
