package org.net9.tinymoeface.trainer;

import java.io.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

public class FaceDetectionTrainer
{
    protected static void loadOpenCV()
    {
        try {
            String LIBRARY_PATH = "libs";
            String jarPath = FaceDetectionTrainer.class.getProtectionDomain().
                getCodeSource().getLocation().toURI().getPath();
            String jarDirectory = new File(jarPath).getParentFile().toString();
            String libDirectory = jarDirectory + File.separator + LIBRARY_PATH;
            File[] openCVLibArr;
            File libDirectoryFile = new File(libDirectory);
            openCVLibArr = libDirectoryFile.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.contains(Core.NATIVE_LIBRARY_NAME);
                }
            });
            System.load(libDirectory + File.separator + openCVLibArr[0].getName());
        }
        catch(Exception e) {
            System.out.println("Cannot load openCV native dynamic library.");
            e.printStackTrace(System.out);
            System.out.println("Application will now exit.");
            System.exit(1);
        }
    }
    public static void main(String[] args)
    {
        System.out.println("This is a stub.");
        loadOpenCV();
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat matrix = new Mat(5, 5, CvType.CV_8UC1, new Scalar(42));
        System.out.println("OpenCV Mat: " + matrix);
        System.out.println("OpenCV Mat data:\n" + matrix.dump());
    }
}
