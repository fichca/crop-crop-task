package mts.teta.resizer.service;

import mts.teta.resizer.console.ResizerApp;

import java.lang.reflect.*;

public class ImageProcessor {

    private final OperationService operationService;

    public ImageProcessor(OperationService operationService) {
        this.operationService = operationService;
    }

    public void processImage(ResizerApp resizerApp) {

        try {
            invokeMethodByOperation(resizerApp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void invokeMethodByOperation(ResizerApp resizerApp) throws NoSuchMethodException {
        String operation = resizerApp.getOperation();
        Class<? extends OperationService> aClass = operationService.getClass();
        Method declaredMethod = aClass.getDeclaredMethod(operation, ResizerApp.class);

        try {
            declaredMethod.invoke(operationService, resizerApp);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
