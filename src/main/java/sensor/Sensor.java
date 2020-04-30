package sensor;

import database.TempDTO;
import javaFx.*;

import java.sql.Timestamp;

public class Sensor implements tempSensor, Runnable {

    private tempListener observer;

    public void run() {
        while (true) {
            TempDTO tempDTO = new TempDTO();
            double min = 140;
            double max = 220;
            double value = (Math.random() * ((max - min)) + min);
            double temp = (value * 4.0 / 50.0) + 24.0;
            tempDTO.setTemp(temp);
            tempDTO.setTid(new Timestamp(System.currentTimeMillis()));
            if (observer != null) {
                observer.inform(tempDTO);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void register(AppGUIController listener) {
        this.observer = listener;
    }
}
