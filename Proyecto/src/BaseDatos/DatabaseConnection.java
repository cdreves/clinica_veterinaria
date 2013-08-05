package BaseDatos;


import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import Formularios.Main;
import com.mysql.jdbc.log.Log;

/**
 * Conexi贸n a la base de datos (MySql), con patr贸n Singleton
 * @autor Carlos Dreves N.
 * @version 1.0.0.0
 */

public class DatabaseConnection{
	   
	static Logger logger = Logger.getLogger(DatabaseConnection.class);

    private static Connection conn; // atributo donde se guarda el objeto de conexi锟絥.
 
    /**
     * M茅todo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return INSTANCE retorna una instancia de la conexi锟絥 a la base de datos
     */
    
    public Connection getConnection() 
    {
        if (conn == null)
         performConnection();
         
        return conn;
    }
 
    /**
     * M茅todo para eliminar la instancia de la conexi贸n
     */
    
    public void delConnection()
    {
     try
     {
      conn.close();
     }
     catch(SQLException e)
     {
      
     }
     conn = null;
    }
 
 
    /**
     * M茅todo que crea la conexi贸n a la base de datos
     * @return conn retorna el atributo de conexi锟絥 del objeto Connection.
     */
    
    public static void performConnection() 
    {
        PropertyConfigurator.configure("log4j.properties");

        String host = "localhost";//cambiar por tu host de la base de datos
        String user = "root";//cambiar por tu usuario de la base de datos
        String pass = "root";//cambiar por tu contrase馻 de la base de datos
        String dtbs = "clinica_veterinaria";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexi贸n
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            conn = DriverManager.getConnection(newConnectionURL);
            logger.info("Se ha establecido conexi髇 con la base de datos.");
            
        } catch (Exception e) {
            logger.error("Error al abrir la conexi髇: "+e);
        }
    }
    
}