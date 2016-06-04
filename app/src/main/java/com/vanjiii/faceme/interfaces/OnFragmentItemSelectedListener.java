package com.vanjiii.faceme.interfaces;

import android.net.Uri;

import com.vanjiii.faceme.beans.Person;

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
     * Call the main navigation fragment.
     */
    void callMainNavigationFragment();

    /**
     * Call the SavePhotoFragment. It gives the possibility to add info to taken picture and manipulated the existing one.
     */
    void callSavePhotoFragment(boolean isComingFromAdapter, Person person);

    /**
     * Call the fragment so that user can manipulate the taken photo.
     * @param uri The URI of the photo.
     */
    void callPreviewPhotoFragment(Uri uri);

    /**
     * Call the fragment that shows all the taken photos as array-adapter
     */
    void callPreviewAllPhotosFragment();

}
