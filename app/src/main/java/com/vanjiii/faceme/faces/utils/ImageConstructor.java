package com.vanjiii.faceme.faces.utils;

import android.graphics.Bitmap;

/**
 * A class containing methods to construct images from the different representations used.
 *
 * @author Boris
 */
public class ImageConstructor {

    /** Construct image from array of ColorPixels */
    public static Bitmap createImage(ColorPixel [][] colors) {
        int w = colors[0].length;
        int h = colors.length;
        int []imagePixels = new int[h * w];
        for (int i  = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                imagePixels[i * w + j] =
                        (colors[i][j].red << 16) | (colors[i][j].green << 8) | colors[i][j].blue;
            }
        }
        return getImageFromArray(imagePixels, w, h);
    }

    /** Creates an image from two-dimensional grayscale array. */
    public static Bitmap createImage(Number [][] grayScale) {
        int w = grayScale[0].length;
        int h = grayScale.length;
        int []imagePixels = new int[h * w];
        for (int i  = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                imagePixels[i * w + j] = ((1 << 16) | (1 << 8) | 1) * grayScale[i][j].intValue();
            }
        }
        return getImageFromArray(imagePixels, w, h);
    }

    /** Creates an image from two-dimensional grayscale array. */
    public static Bitmap createImage(int [][] grayScale) {
        int w = grayScale[0].length;
        int h = grayScale.length;
        int []imagePixels = new int[h * w];
        for (int i  = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                imagePixels[i * w + j] = ((1 << 16) | (1 << 8) | 1) * grayScale[i][j];
            }
        }
        return getImageFromArray(imagePixels, w, h);
    }

    /** Creates an image stored in file from two-dimensional grayscale array. */
    public static Bitmap createImage(double[] grayScale, int h, int w) {
        int []imagePixels = new int[grayScale.length];
        for (int i  = 0; i < grayScale.length; i++) {
            imagePixels[i] = ((1 << 16) | (1 << 8) | 1) * (int)grayScale[i];
        }
        return getImageFromArray(imagePixels, w, h);
    }

    /** Helper function for constructing image. */
    private static Bitmap getImageFromArray(int[] pixels, int width, int height) {
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        Bitmap image = Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
        image.getPixels(pixels, 0, width, 0, 0, width, height);
        return image;
    }
}
