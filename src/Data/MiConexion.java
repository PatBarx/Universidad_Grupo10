package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Grupo10
 */
public class MiConexion {
    private String url;
    private String usuario;
    private String pass;
    
    private Connection conexion;    //atributo

    public MiConexion(String url, String usuario, String pass) {
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Connection buscarConexion() {
        if (conexion == null) {  //si es la primera vez q se usa la vamos a establecer
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario , pass);
            } catch (SQLException |ClassNotFoundException ex) { //si no deja poner SQLException | delante de la Class..excepcion es porque falta la linea de arriba
                Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion; //retorna la conexion establecida
    }    
    
}
