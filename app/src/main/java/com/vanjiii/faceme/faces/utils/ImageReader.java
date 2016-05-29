package com.vanjiii.faceme.faces.utils;

import android.graphics.Bitmap;

public class ImageReader {
//    /**
//     * Reads an image file and constructs an array with its color pixels.
//     */
//    public static ColorPixel[][] getImagePixels(File imageFile) {
//        ColorPixel[][] pixels = null;
//        try {
//            BufferedImage img;
//            img = ImageIO.read(imageFile);
//            pixels = getRgbPixels(img);
//        } catch (IOException e) {
//            System.out.println("Could not find the image file: " + imageFile);
//            e.printStackTrace();
//        }
//        return pixels;
//    }
//
//    /**
//     * Gets the rgb values of the given image
//     */
//    private static ColorPixel[][] getRgbPixels(BufferedImage img) {
//        int w = img.getWidth();
//        int h = img.getHeight();
//        int[] rgbArray = new int[h * w];
//        img.getRGB(0, 0, w, h, rgbArray, 0, w);
//        ColorPixel[][] rgbPixels = new ColorPixel[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                rgbPixels[i][j] = new ColorPixel(rgbArray[i * w + j]);
//            }
//        }
//        return rgbPixels;
//    }

    public static ColorPixel[][] getImagePixels(Bitmap image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int[] rgbArray = new int[h * w];
        image.getPixels(rgbArray, 0, w, 0, 0, w, h);
        ColorPixel[][] rgbPixels = new ColorPixel[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rgbPixels[i][j] = new ColorPixel(rgbArray[i * w + j]);
            }
        }
        return rgbPixels;
    }
}
