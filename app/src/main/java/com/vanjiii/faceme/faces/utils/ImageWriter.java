package com.vanjiii.faceme.faces.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageWriter {
    private static final String OUT_IMAGE_FORMAT = "jpg";
//
//    /**
//     * Creates an image stored in file from two-dimensional grayscale array.
//     *
//     * @param fileName The name of the file in which the image will be stored (only name, not path).
//     * @param grayScale The grayscale image pixels in one-dimensional array.
//     * @param h The height of the image in pixels
//     * @param w The width of the image in pixels
//     * @param needScaling whether the image should be scaled to fit prespecified dimensions
//     */
//    public static void createImage(String fileName, double[] grayScale, int h, int w,
//            boolean needScaling) {
//        writeImage(ImageConstructor.createImage(grayScale, h, w), fileName, needScaling);
//    }
//
//    /**
//     * Creates an image stored in file from two-dimensional grayscale array.
//     *
//     * @param fileName The name of the file in which the image will be stored (only name, not path).
//     * @param grayScale The grayscale image pixels.
//     * @param needScaling whether the image should be scaled to fit prespecified dimensions
//     */
//    public static void createImage(String fileName, Number [][] grayScale, boolean needScaling) {
//        writeImage(ImageConstructor.createImage(grayScale), fileName, needScaling);
//    }

//    /**
//     * Creates an image stored in file from two-dimensional grayscale array.
//     *
//     * @param fileName The name of the file in which the image will be stored (only name, not path).
//     * @param grayScale The grayscale image pixels.
//     * @param needScaling whether the image should be scaled to fit prespecified dimensions
//     */
//    public static void createImage(String fileName, int [][] grayScale, boolean needScaling) {
//        writeImage(ImageConstructor.createImage(grayScale), fileName, needScaling);
//    }

//    /** Prints an image to a file stored in the default image location: */
//    public static void createImage(String fileName, ColorPixel [][] colors, boolean needScaling) {
//        writeImage(ImageConstructor.createImage(colors), fileName, needScaling);
//    }
//
////    /** Prints an image to the specified location. */
////    public static void createImage(File outputFile, ColorPixel [][] colors, boolean needScaling) {
////        writeImage(ImageConstructor.createImage(colors), outputFile, needScaling);
////    }
//
//    public static void writeImage(Bitmap image, String fileName, boolean needScaling) {
//        File outputFile = new File(fileName);
//        if (outputFile.getParentFile() != null) {
//            outputFile.getParentFile().mkdirs();
//        }
//        writeImage(image, outputFile, needScaling);
//    }
//
//    private static void writeImage(Bitmap image, File outputFile, boolean needScaling) {
//        try {
//            Bitmap scaledImage = (needScaling) ? ImageScaler.rescaleImage(image) : image;
//            ImageIO.write(scaledImage, OUT_IMAGE_FORMAT, outputFile);
//        } catch (IOException e) {
//            System.out.println("The image could not be written");
//            e.printStackTrace();
//        }
//    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(String name){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/Android/data/"
                + "faceme"
                + "/Files");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName="MI_"+ timeStamp + name +".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }

    public static Bitmap createImage(int [][] colors) {
        return ImageConstructor.createImage(colors);


    }

    public static Bitmap createImage(ColorPixel [][] colors) {
        return ImageConstructor.createImage(colors);
    }

    public static void storeImage(Bitmap image){
        storeImage("", image);
    }

    public static void storeImage(String name, Bitmap image) {
        File pictureFile = getOutputMediaFile(name);
        if (pictureFile == null) {
            Log.d("faceme",
                    "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.JPEG, 0, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d("faceme", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("faceme", "Error accessing file: " + e.getMessage());
        }



//        String root = Environment.getExternalStorageDirectory().toString();
//        File myDir = new File(root + "/saved_images");
//        myDir.mkdirs();
//        Random generator = new Random();
//        int n = 10000;
//        n = generator.nextInt(n);
//        String fname = "Image-"+ n +".jpg";
//        File file = new File (myDir, fname);
//        if (file.exists ()) file.delete ();
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            image.compress(Bitmap.CompressFormat.JPEG, 90, out);
//            out.flush();
//            out.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

}
