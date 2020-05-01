package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class TempDAOImpl implements TempDAO {

    public void save(TempDTO tempDTO) {
        Connection conn = connector.getConn();
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Målinger (ID,Temp,Tid) values (?,?,?)");
            statement.setInt(1, tempDTO.getId());
            statement.setDouble(2, tempDTO.getTemp());
            statement.setTimestamp(3, tempDTO.getTid());
            statement.execute();
            System.out.println("Saveing to database!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TempDTO> load(int id) {
        List<TempDTO> data = new ArrayList<TempDTO>();
        Connection conn = connector.getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Målinger WHERE id = ? ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TempDTO tempDTO = new TempDTO();
                tempDTO.setId(resultSet.getInt("ID"));
                tempDTO.setTemp(resultSet.getDouble("Temp"));
                tempDTO.setTid(resultSet.getTimestamp("Tid"));
                data.add(tempDTO);
                System.out.println("Loadind from database!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}








