package database;

import java.sql.Timestamp;

public class TempDTO {

    private double temp;
    private Timestamp tid;
    private String cpr;

    public TempDTO() {

    }

    public TempDTO(double temp, Timestamp tid) {
        this.temp = temp;
        this.tid = tid;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
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
