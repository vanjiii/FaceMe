package com.vanjiii.faceme.interfaces;

import android.net.Uri;

/**
 * Listener which is used for communication between main fragments and their containing activity.
 * <p>
 * Created by vanjiii on 07.05.16.
 */
public interface OnFragmentItemSelectedListener {

    /**
     * Call the activity that shows all available Db tables.
     */
    void callDatabaseViewerActivity();

    /**
     * Call the SavePhotoFragment. It gives the possibility to add info to taken picture and manipulated the existing one.
     *
     * @param uri Uri of the taken picture.
     */
    void callSavePhotoFragment(Uri uri);

    void callPreviewAllPhotosFragment();

}
