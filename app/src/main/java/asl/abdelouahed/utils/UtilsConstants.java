package asl.abdelouahed.utils;

/**
 * Created by abdelouahed on 2/15/18.
 */

public class UtilsConstants {

    private UtilsConstants() {
    }

    public static final String INPUT_NAME = "Mul";
    public static final String OUTPUT_NAME = "final_result";

    public static final String MODEL_FILE_PATH = "file:///android_asset/output_graph.pb";
    public static final String LABEL_FILE_PATH = "file:///android_asset/output_labels.txt";

    public static final int INPUT_SIZE = 299;
    public static final int IMAGE_MEAN = 128;
    public static final float IMAGE_STD = 128f;

    public static final double MIN_CONFIDENCE = 0.4;

    public static final long RECOGNITION_DELAY = 3000;

    static final double MAX_VALUE = 255;
    static final int GAUSSIAN_BLUR = 3;

}
