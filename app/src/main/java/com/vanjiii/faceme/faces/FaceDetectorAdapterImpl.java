package com.vanjiii.faceme.faces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.vanjiii.faceme.faces.initial_manipulation.FaceDetector;
import com.vanjiii.faceme.faces.initial_manipulation.ImageCropper;
import com.vanjiii.faceme.faces.utils.ColorPixel;
import com.vanjiii.faceme.faces.utils.GrayscaleConverter;
import com.vanjiii.faceme.faces.utils.ImageReader;
import com.vanjiii.faceme.faces.utils.ImageWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Implementation of the FaceDetectorAdapter interface.
 *
 * Created by vanjiii on 28.05.16.
 */
public class FaceDetectorAdapterImpl implements FaceDetectorAdapter {
    @Override
    public Bitmap findFace(Uri uri, Context context) {
        Bitmap bitmap = null;
        Bitmap res = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            res = compressPhoto(bitmap);

            ImageWriter.storeImage("initial_photo", res);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //File to ColorPixel[][]
        ColorPixel[][] imagePixels = ImageReader.getImagePixels(res);

        //ColorPixel[][] to int[][]
        int[][] grayscale = GrayscaleConverter.getImageGrayscale(imagePixels);
        //int[][] from faceDetector to CropRegion
        ImageCropper.CropRegion faceRegion = FaceDetector.findFace(grayscale, true, false);
        //cropRegion to image
        ImageCropper cropper = new ImageCropper();
        ColorPixel[][] result = cropper.cropImage(imagePixels, faceRegion);
        Bitmap cropBTRes = ImageWriter.createImage(result);


        return cropBTRes;
    }

    public Bitmap compressPhoto(Bitmap photo) {
        return Bitmap.createScaledBitmap(photo, 960, 1280, true);
    }
}
