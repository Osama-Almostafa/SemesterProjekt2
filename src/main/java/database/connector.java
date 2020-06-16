package database; // bibliotek

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
    private static Connection conn; // // En Interface er en slags type, ligesom en klasse.
    // Som et resultat kan du bruge en Interface som type for en variabel, parameter eller metodeleverdi.

    private connector() {
    }

    public static Connection getConn() { // Man implementere interfacet, for at oprette forbindelse til Database
        try {
            if (conn == null || conn.isClosed()) { // der oprettes en if branch.
                //Hvis der ikke bliver oprettede forbindelse eller databasen er lukkede,
                // hvor der bliver udfyldt parameteres, som idenficere hvilke data base.
                conn = DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/s184727?" +
                        "user=s184727&password=YFSAiO2H36af4AuFbw3A3");
                System.out.println("Connection established!!"); // printer hvis der med succes forbindelse
            }
        } catch (SQLException e) { // da der bliver oprettet forbindelse uden fra Java, her bliver fejl oplyst.
            e.printStackTrace();
        }
        return conn; // retunere forbindelsen
    }
}


