package com.vanjiii.faceme.fragments;

import android.support.v4.app.Fragment;
import android.net.Uri;

/**
 * Fragment that shows the taken picture and gives the possibility to add info about the person.
 * <p>
 * Created by vanjiii on 08.05.16.
 */
public class SavePhotoFragment extends Fragment {

    private Uri pictureUri;

    public SavePhotoFragment() {

    }


    public Uri getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(Uri pictureUri) {
        this.pictureUri = pictureUri;
    }
}
