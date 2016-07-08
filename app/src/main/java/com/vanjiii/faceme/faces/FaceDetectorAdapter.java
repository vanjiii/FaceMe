package com.vanjiii.faceme.faces;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Interface for communication to the Face recognition algorithm.
 *
 * Created by vanjiii on 28.05.16.
 */
public interface FaceDetectorAdapter {

    /**
     * Find face on input image.
     *
     * @param uri The resource path to the actual photo
     * @param context context of the main element
     * @return Bitmap object
     */
    Bitmap findFace(Uri uri, Context context);

}
