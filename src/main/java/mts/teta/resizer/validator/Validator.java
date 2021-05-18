package mts.teta.resizer.validator;

import mts.teta.resizer.console.ResizerApp;
import mts.teta.resizer.imageprocessor.BadAttributesException;
import mts.teta.resizer.imageprocessor.ConstantsException;
import mts.teta.resizer.service.OperationService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validator {

    public boolean validParameters(ResizerApp resizerApp) {
        String operation = resizerApp.getOperation();

        try {
            if (validOperation(operation)) {
                Class<ValidOperation> validOperationClass = ValidOperation.class;
                ValidOperation validOperation = new ValidOperation();
                try {
                    Method declaredMethod = validOperationClass.getDeclaredMethod(operation, ResizerApp.class);
                    try {
                        return (boolean) declaredMethod.invoke(validOperation, resizerApp);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }else {
                throw new BadAttributesException(ConstantsException.INVALID_OPERATION + " " + operation);
            }
        } catch (BadAttributesException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validOperation(String operation) {
        if (operation != null) {
            Class<OperationService> operationServiceClass = OperationService.class;
            Method[] declaredMethods = operationServiceClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getName().contains(operation)) {
                    return true;
                }
            }
        }
        return false;
    }
}
