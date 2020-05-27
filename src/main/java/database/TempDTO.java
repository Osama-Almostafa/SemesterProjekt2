package database;

import java.sql.Timestamp;

public class TempDTO { // Her oprettes TempDTO (Data transfer Objekt)

    private double temp; // der laves 3 atributter af samme type som i Databasen
    private Timestamp tid;
    private int id;

    // en set metode giver en værdi til en variabel i en klasse. og get henter den værdi igen.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } // This peger præcis på denne parameter for at undgå forvirring.

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
