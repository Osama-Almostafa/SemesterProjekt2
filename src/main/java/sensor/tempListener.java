package sensor;

import database.TempDTO;

public interface tempListener {
    void inform(TempDTO tempDTO); // her informeres i app'en at der kommer tempDTO'er
}
