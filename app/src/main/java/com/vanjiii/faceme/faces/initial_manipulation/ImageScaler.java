package com.vanjiii.faceme.faces.initial_manipulation;

import com.vanjiii.faceme.faces.initial_manipulation.ImageCropper.CropRegion;


public class ImageScaler {
    public static Integer TARGET_WIDTH = 110;
    public static Integer TARGET_HEIGHT = 150;

    public static CropRegion chooseMostAppropriateRegion(CropRegion region, int totalArea) {
        CropRegion result = new CropRegion();
        result.x1 = region.x1;
        result.y1 = region.y1;
        result.x2 = region.x2;
        result.y2 = region.y2;
        boolean shouldDownscale = (result.x2 - result.x1) * (result.y2 - result.y1) * 10 > totalArea * 6;
        int step = shouldDownscale ? 1 : -1;
        if (((result.x2 - result.x1) * TARGET_WIDTH > (result.y2 - result.y1) * TARGET_HEIGHT)
                == shouldDownscale) {
            while (((result.x2 - result.x1) * TARGET_WIDTH > (result.y2 - result.y1) * TARGET_HEIGHT)
                    == shouldDownscale) {
                if (shouldDownscale) {
                    result.x2 -= step;
                } else {
                    result.x1 += step;
                }
            }
        } else {
            boolean left = true;
            while (((result.x2 - result.x1) * TARGET_WIDTH < (result.y2 - result.y1) * TARGET_HEIGHT)
                    == shouldDownscale) {
                if (left) {
                    result.y1 += step;
                } else {
                    result.y2 -= step;
                    ;
                }
                left = !left;
            }
        }
        return result;
    }
}
