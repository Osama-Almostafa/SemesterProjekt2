package sensor;

import javaFx.*;

public interface tempSensor {
    void register(AppGUIController listener); // AppGUIcontroller registrerer sig som listener(observere) i sensoren
}
