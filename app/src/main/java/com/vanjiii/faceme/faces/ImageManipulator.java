package com.vanjiii.faceme.faces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by vanjiii on 28.05.16.
 */
public class ImageManipulator {

    public static Bitmap convertToGrayscale(Bitmap bitmapOriginal)
    {
        int height = bitmapOriginal.getHeight();
        int width = bitmapOriginal.getWidth();

//        Bitmap grayscaleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Bitmap grayscaleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(grayscaleBitmap);
        Paint paint = new Paint();
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        paint.setColorFilter(filter);
        canvas.drawBitmap(bitmapOriginal, 0, 0, paint);
        return grayscaleBitmap;
    }

}
