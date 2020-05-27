package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class TempDAOImpl implements TempDAO { // her oprettes klassen som implementere metoderne i interfacet TempDAO

    public void save(TempDTO tempDTO) {
        Connection conn = connector.getConn(); // her erklares objektet af interfacet connection og tildeles værdien fra
        // klassen connecter conn
        try {
            // Først laves der en SQL statement som er PreparedStatement, der indsætter værdier ind i databasen (DML)
            // spørgsmåltegnet er værdier til ID Temp og Tid
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Målinger (ID,Temp,Tid) values (?,?,?)");
            statement.setInt(1, tempDTO.getId()); // Her vælges de rigtige datatyper
            statement.setDouble(2, tempDTO.getTemp()); // =/=
            statement.setTimestamp(3, tempDTO.getTid()); // =/=
            statement.execute(); // her udføres alle de forrige statements
            System.out.println("Saved to database!!"); // printer hvis data bliver gemt
        } catch (SQLException e) { // fanger fejl hvis data ikke bliver gemt fordi der er I/O
            e.printStackTrace();
        }
    }

    // i save metoden har man adgang til at skrive i data basen, hvorimod i load metoden hvor man aflæser fra databasen

    public List<TempDTO> load(int id) { // Metoden load() i klassen TempDAOImpl opretter en liste,
        // der kan indeholde TempDTO'er
        List<TempDTO> data = new ArrayList<TempDTO>(); // her bliver listen oprettet
        Connection conn = connector.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Målinger WHERE id = ? ");
            //
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(); // er en pointer, som fortæller at den er
            // klar til at give data fra kolonner
            while (resultSet.next()) { // så længe den er true så henter den række
                TempDTO tempDTO = new TempDTO(); // der oprettes et nyt objekt af klasse tempDTO
                tempDTO.setId(resultSet.getInt("ID")); // heraf tildeles værdierne af resultsettet til setter i TempDTO
                tempDTO.setTemp(resultSet.getDouble("Temp")); // =/=
                tempDTO.setTid(resultSet.getTimestamp("Tid")); // =/=
                data.add(tempDTO); // Her kommer nye TempDTO'er i listen
                System.out.println("Loaded from database!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data; // retunere listen
    }
}








