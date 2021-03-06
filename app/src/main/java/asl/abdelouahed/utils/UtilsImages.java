package asl.abdelouahed.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.ByteArrayOutputStream;

import static asl.abdelouahed.utils.UtilsConstants.GAUSSIAN_BLUR;
import static asl.abdelouahed.utils.UtilsConstants.INPUT_SIZE;
import static asl.abdelouahed.utils.UtilsConstants.MAX_VALUE;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;

/**
 * Created by abdelouahed on 2/15/18.
 */

public class UtilsImages {

    public UtilsImages() {
    }

    public static void matToBinary(Mat mat, int threshold) {
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2));
        // convert to binary
        Imgproc.threshold(mat, mat, threshold, MAX_VALUE, THRESH_BINARY);
        // morphological operation
        Imgproc.erode(mat, mat, kernel);
        Imgproc.dilate(mat, mat, kernel);
        // Gaussian Filter
        Imgproc.GaussianBlur(mat, mat, new Size(GAUSSIAN_BLUR, GAUSSIAN_BLUR), 0);
    }

    public static Bitmap matToBitmap(Mat mat, Rect rect) {
        try {
            Mat mMat = new Mat(mat, rect);
            Bitmap bitmap = Bitmap.createBitmap(mMat.cols(), mMat.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(mMat, bitmap);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
