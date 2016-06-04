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
 * Created by vanjiii on 28.05.16.
 */
public class FaceDetectorAdapterImpl implements FaceDetectorAdapter {
    @Override
    public Bitmap findFace(Uri uri, Context context) {
//        Bitmap grayscale = null;
        Bitmap bitmap = null;
        Bitmap res = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            res = compressPhoto(bitmap);

//            ImageWriter.storeImage("init", res);

        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        Log.d("FaceDetector", "grayscale width: " + grayscale.getWidth());
//        Log.d("FaceDetector", "grayscale width: " + grayscale.getHeight());
//
//        Bitmap result = compressPhoto(grayscale);
//        FaceDetector.findFace(extractImg(result), false, false);
//


        //URI to File
//        File imageFile = new File(uri.getPath());
        //File to ColorPixel[][]
        ColorPixel[][] imagePixels = ImageReader.getImagePixels(res);

        //ColorPixel[][] to int[][]
        int[][] grayscale = GrayscaleConverter.getImageGrayscale(imagePixels);
//        try {
//            ImageWriter.writeToFile(grayscale, context);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        ImageWriter.addGallery(Environment.getExternalStorageDirectory()
//                + "/Android/data/"
//                + "faceme"
//                + "/Files"
//                + "/bla.png", context);
        //int[][] from faceDetector to CropRegion
        ImageCropper.CropRegion faceRegion = FaceDetector.findFace(grayscale, true, false);
        //cropRegion to image
        ImageCropper cropper = new ImageCropper();
        ColorPixel[][] result = cropper.cropImage(imagePixels, faceRegion);
        Bitmap cropBTRes = ImageWriter.createImage(result);


        return cropBTRes;
    }

    //TODO remove unused code
//    private int[][] extractImg(Bitmap photo) {
//        //define the array size
//        int width = photo.getWidth();
//        int height = photo.getHeight();
//
//
//        int[][] rgb = new int[width][height];
//        Log.d("FaceDetector", "after compress width: " + photo.getWidth());
//        Log.d("FaceDetector", "after compress width: " + photo.getHeight());
//
//        for (int i = 0; i < photo.getWidth() - 1; i++) {
//            for (int j = 0; j < photo.getHeight() - 1; j++) {
//                //get the RGB value from each pixel and store it into the array as Color
//                rgb[i][j] = photo.getPixel(i, j);
//            }
//        }
//
//
//        return rgb;
//    }

    public Bitmap compressPhoto(Bitmap photo) {
        return Bitmap.createScaledBitmap(photo, 960, 1280, true);
    }
}
