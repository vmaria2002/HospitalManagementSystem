package controller; /**
 * Pentru conexiunea la baza de date:
 * pas1: file-> progect Sructure ->modules-> + -> selectezi connector-ul(il pui in proiect!!)=applay-->ok
 * .
 */

import java.sql.*;
import java.time.LocalDateTime;

public class DataBaseConnection {

    String driver;
    String dbName;
    String connectionURL;
    String username;
    String password;

    public DataBaseConnection() {
        driver = "com.mysql.jdbc.Driver";
        connectionURL = "jdbc:mysql://localhost:3306/";
        dbName = "spital";
        username = "root";
        password = "";
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionURL + dbName, username, password);

        return connection;
    }


    public static void main(String[] args) {
        controller.DataBaseConnection db = new controller.DataBaseConnection();
        try {

            Connection conn = db.getConnection();
            System.out.println("Database successfully connected!");

//  ***********************  select *********************************************************

//            String sql = "select * from" + " doctor " + " where username =? and parola =?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "ion12");
//            statement.setString(2, "I12");
//            ResultSet result = statement.executeQuery();
//
//            if (result.next()==false){
//                System.out.println("nu avem rezultat");
//            }
//
//            while (result.next()) {
//                System.out.println(result.getString(5));
//            }


//********************************Update*******************************

//            String sql2 = "UPDATE pacienti SET data_inscriere =? WHERE numel = ? and prenume = ?";
//            PreparedStatement statement2 = conn.prepareStatement(sql2);
//            statement2.setString(1, LocalDateTime.now().toString());
//            statement2.setString(2, "Vasilache");
//            statement2.setString(3, "Maria");
//
//            statement2.executeUpdate();



            //Update mai complex:
            String sql2 = "UPDATE pacienti SET diagnostic =?, cheltuieli=?, doctori=?  WHERE numel=? and prenume=?";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setString(1, "bronsita");
            statement2.setFloat(2, 12);
            statement2.setString(3,"Anca Serea" );
            statement2.setString(4, "Vasilache");
            statement2.setString(5, "Maria");

            statement2.executeUpdate();

            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}