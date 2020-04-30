package sensor;

import database.TempDTO;

public interface tempListener {
    void inform(TempDTO tempDTO);
}
