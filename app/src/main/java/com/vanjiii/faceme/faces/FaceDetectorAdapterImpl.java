package com.vanjiii.faceme.faces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.provider.MediaStore;

import com.vanjiii.faceme.faces.initial_manipulation.FaceDetector;

import java.io.IOException;

/**
 * Created by vanjiii on 28.05.16.
 */
public class FaceDetectorAdapterImpl implements FaceDetectorAdapter {
    @Override
    public Uri findFace(Uri uri, Context context) {
        Bitmap grayscale = null;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            grayscale = ImageManipulator.convertToGrayscale(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FaceDetector.findFace(extractImg(grayscale), false, false);

        return null;
    }

    public int[][] extractImg(Bitmap photo) {
        //define the array size
        int[][] rgb = new int[photo.getWidth()][photo.getHeight()];

        for (int i = 0; i < photo.getWidth() - 1; i++) {
            for (int j = 0; j < photo.getHeight() - 1; j++) {
                //get the RGB value from each pixel and store it into the array as Color
                rgb[i][j] = photo.getPixel(i, j);
            }
        }

        return rgb;
    }
}
