package database;

import java.sql.Timestamp;

public class TempDTO {

    private double temp;
    private Timestamp tid;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Timestamp getTid() {
        return tid;
    }

    public void setTid(Timestamp tid) {
        this.tid = tid;
    }
}
