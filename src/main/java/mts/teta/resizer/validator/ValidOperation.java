package mts.teta.resizer.validator;

import mts.teta.resizer.console.ResizerApp;
import mts.teta.resizer.entity.FormatIMG;
import mts.teta.resizer.imageprocessor.BadAttributesException;
import mts.teta.resizer.service.OperationService;

import java.io.File;

import static mts.teta.resizer.imageprocessor.ConstantsException.*;

public class ValidOperation implements OperationService {

    private final static String errorNegative = " cannot be negative";

    public boolean resize(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();
        int resizeHeight = resizerApp.getResizeHeight();
        int resizeWidth = resizerApp.getResizeWidth();

        try {
            validFiles(inputFile, outputFile);
            validWidthAndHeight(resizeHeight, resizeWidth);
            return true;
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean crop(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();
        int resizeHeight = resizerApp.getResizeHeight();
        int resizeWidth = resizerApp.getResizeWidth();
        int y = resizerApp.getY();
        int x = resizerApp.getX();

        try {
            validFiles(inputFile, outputFile);
            validWidthAndHeight(resizeHeight, resizeWidth);
            if (x <= 0) {
                throw new BadAttributesException(INVALID_PARAMETER_X + errorNegative);
            } else if (y <= 0) {
                throw new BadAttributesException(INVALID_PARAMETER_Y + errorNegative);
            }
            return true;
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean quality(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();
        int quality = resizerApp.getQuality();

        try {
            validFiles(inputFile, outputFile);
            if (quality <= 0) {
                throw new BadAttributesException(INVALID_PARAMETER_QUALITY + errorNegative);
            } else if (quality >= 100) {
                throw new BadAttributesException(INVALID_PARAMETER_QUALITY + " cannot be more than 100");
            }
            return true;
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }
//        if (inputFile != null && outputFile != null && 0 < quality && quality < 100) {
////            if (outputFile.canWrite()) {
//            return inputFile.canRead();
////            }
//        }
        return false;
    }

    public boolean blur(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();
        int blurRadius = resizerApp.getBlurRadius();
        try {
            validFiles(inputFile, outputFile);
            if (0 <= blurRadius) {
                throw new BadAttributesException(INVALID_PARAMETER_BLUR + errorNegative);
            }
            return true;
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }
//        if (inputFile != null && outputFile != null && 0 < blurRadius) {
////            if (outputFile.canWrite()) {
//            return inputFile.canRead();
////            }
//        }
        return false;
    }

    public boolean format(ResizerApp resizerApp) {
        File outputFile = resizerApp.getOutputFile();
        File inputFile = resizerApp.getInputFile();
        String format = resizerApp.getFormat();

        try {
            validFiles(inputFile, outputFile);
            if (format != null) {
                try {
                    FormatIMG.valueOf(format);
                    return true;
                } catch (IllegalArgumentException e) {
                    throw new BadAttributesException(INVALID_PARAMETER_FORMAT);
                }
            } else {
                throw new BadAttributesException(INVALID_PARAMETER_FORMAT + " write format");
            }
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }

//        if (inputFile != null && outputFile != null && format != null) {
//
//            try {
//                FormatIMG.valueOf(format);
//            } catch (IllegalArgumentException e) {
//                return false;
//            }
////            if (outputFile.canWrite()) {
//            return inputFile.canRead();
////            }
//        }
        return false;
    }

    private void validFiles(File input, File output) throws BadAttributesException {
        if (!input.getPath().equals(FILE_NOT_FOUND)) {
            if (!input.canRead()) {
                throw new BadAttributesException(INVALID_PARAMETER_INPUT_FILE + "cannot read input file");
            }
        } else {
            throw new BadAttributesException(INVALID_PARAMETER_INPUT_FILE + "write input file");
        }
        if (output.getPath().equals(FILE_NOT_FOUND)) {
            throw new BadAttributesException(INVALID_PARAMETER_OUTPUT_FILE + "write output file");
        }
    }

    private void validWidthAndHeight(int resizeHeight, int resizeWidth) throws BadAttributesException {
        if (resizeHeight <= 0) {
            throw new BadAttributesException(INVALID_PARAMETER_HEIGHT);
        } else if (resizeWidth <= 0) {
            throw new BadAttributesException(INVALID_PARAMETER_WIDTH);
        }
    }
}
