package mts.teta.resizer.service;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.console.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;
import org.marvinproject.image.segmentation.crop.Crop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OperationServiceImpl implements OperationService{


    public boolean resize(ResizerApp resizerApp) {
        int resizeWidth = resizerApp.getResizeWidth();
        int resizeHeight = resizerApp.getResizeHeight();
        File outputFile = resizerApp.getOutputFile();
        BufferedImage read = null;
        try {
            read = ImageIO.read(resizerApp.getInputFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thumbnails.of(read).forceSize(resizeWidth, resizeHeight).toFile(outputFile);
            return true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return false;
    }

    public boolean crop(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();

        int resizeWidth = resizerApp.getResizeWidth();
        int resizeHeight = resizerApp.getResizeHeight();
        int x = resizerApp.getX();
        int y = resizerApp.getY();

        MarvinImage imageIn = MarvinImageIO.loadImage(inputFile.getPath());
        MarvinImage imageOut = imageIn.clone();
        Crop crop = new Crop();
        crop.load();

        crop.setAttribute("x", x);
        crop.setAttribute("y", y);
        crop.setAttribute("width", resizeWidth);
        crop.setAttribute("height", resizeHeight);

        crop.process(imageIn, imageOut);
        MarvinImageIO.saveImage(imageOut, outputFile.getPath());
        return true;
    }


    public boolean quality(ResizerApp resizerApp) {

        File outputFile = resizerApp.getOutputFile();
        int quality = resizerApp.getQuality();

        BufferedImage read;
        try {
            read = ImageIO.read(resizerApp.getInputFile());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        int width = resizerApp.getResizeWidth();
        int height = resizerApp.getResizeHeight();

        if (width == 0){
            width = read.getHeight();
        }
        if (height == 0){
            height = read.getHeight();
        }
        try {
            Thumbnails.of(read).forceSize(width, height).outputQuality((double) quality / 100).toFile(outputFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean blur(ResizerApp resizerApp) {

        int blurRadius = resizerApp.getBlurRadius();
        MarvinImage imageIn = MarvinImageIO.loadImage(resizerApp.getInputFile().getPath());
        MarvinImage clone = imageIn.clone();
        MarvinPluginCollection.gaussianBlur(imageIn, clone, blurRadius);
        MarvinImageIO.saveImage(clone, resizerApp.getOutputFile().getPath());
        return true;
    }

    public boolean format(ResizerApp resizerApp) {
        String format = resizerApp.getFormat();
        File outputFile = resizerApp.getOutputFile();
        BufferedImage read;
        try {
            read = ImageIO.read(resizerApp.getInputFile());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            int height = read.getHeight();
            int width = read.getWidth();
            Thumbnails.of(read).forceSize(width, height).outputFormat(format).toFile(outputFile);
            return true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }
    }
}
