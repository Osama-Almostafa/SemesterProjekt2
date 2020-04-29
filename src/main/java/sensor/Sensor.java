package sensor;

import javaFx.*;

public class Sensor implements tempSensor, Runnable {

    private tempListener observer;

    public void run() {
        while (true)
            try {
                double min = 140;
                double max = 220;
                double value = (Math.random() * ((max - min)) + min);
                double temp = (value * 4.0 / 50.0) + 24.0;
                Thread.sleep(500);
                if (observer != null) {
                    observer.inform(temp);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void registerObserver(AppGUIController listener) {
        this.observer = listener;
    }
}
