package com.vanjiii.faceme.faces;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by vanjiii on 28.05.16.
 */
public interface FaceDetectorAdapter {

    Bitmap findFace(Uri uri, Context context);

}
