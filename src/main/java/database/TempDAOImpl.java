package database;

import java.sql.*;

public class TempDAOImpl implements TempDAO {

    Connection conn = connector.getConn();

    public String save(TempDTO tempDTO) {

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Målinger (ID,Temp,Tid) values (?,?,?)");
            statement.setString(1, tempDTO.getCpr());
            statement.setDouble(2, tempDTO.getTemp());
            statement.setTimestamp(3, tempDTO.getTid());
            System.out.println("Connection established");
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TempDTO load(TempDTO tempDTO) {

        try {
            Statement statement = conn.createStatement();
            ResultSet show_tables = statement.executeQuery("SELECT Temp FROM Målinger");
            TempDTO TempDTO = new TempDTO();
            while (show_tables.next()) {
                TempDTO.setTemp(show_tables.getDouble("Temp"));
            }
            return TempDTO;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}








