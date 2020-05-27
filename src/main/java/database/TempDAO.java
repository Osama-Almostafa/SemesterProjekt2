package database;

import java.util.List;

public interface TempDAO { // Data Acces objekt interface, som er en kontrakt

    void save(TempDTO tempDTO); // der bliver gemt data FRA Data transfer objekt

    List<TempDTO> load(int id); // her loader den I DTO
}


