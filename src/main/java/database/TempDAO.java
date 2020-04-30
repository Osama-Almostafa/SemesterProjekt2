package database;

import java.util.List;

public interface TempDAO {

    void save(TempDTO tempDTO);

    List<TempDTO> load(int id);
}


