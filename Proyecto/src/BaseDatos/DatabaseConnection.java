package BaseDatos;


import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import Formularios.Main;
import com.mysql.jdbc.log.Log;

/**
 * Conexión a la base de datos (MySql), con patrón Singleton
 * @autor Carlos Dreves N.
 * @version 1.0.0.0
 */

public class DatabaseConnection{
	   
	static Logger logger = Logger.getLogger(DatabaseConnection.class);

    private static Connection conn; // atributo donde se guarda el objeto de conexi�n.
 
    /**
     * Método para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return INSTANCE retorna una instancia de la conexi�n a la base de datos
     */
    
    public Connection getConnection() 
    {
        if (conn == null)
         performConnection();
         
        return conn;
    }
 
    /**
     * Método para eliminar la instancia de la conexión
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
     * Método que crea la conexión a la base de datos
     * @return conn retorna el atributo de conexi�n del objeto Connection.
     */
    
    public static void performConnection() 
    {
        PropertyConfigurator.configure("log4j.properties");

        String host = "localhost";//cambiar por tu host de la base de datos
        String user = "cdreves";//cambiar por tu usuario de la base de datos
        String pass = "08012009";//cambiar por tu contraseña de la base de datos
        String dtbs = "clinica_veterinaria";//cambiar por tu nombre de la base de datos
 
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            conn = DriverManager.getConnection(newConnectionURL);
            logger.info("Se ha establecido conexi�n con la base de datos.");
            
        } catch (Exception e) {
            logger.error("Error al abrir la conexi�n: "+e);
        }
    }
    
}