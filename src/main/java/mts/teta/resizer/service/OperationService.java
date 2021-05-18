package mts.teta.resizer.service;

import mts.teta.resizer.console.ResizerApp;

public interface OperationService {

    boolean resize(ResizerApp resizerApp);

    boolean crop(ResizerApp resizerApp);

    boolean quality(ResizerApp resizerApp);

    boolean blur(ResizerApp resizerApp);

    boolean format(ResizerApp resizerApp);
}
