package Data;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Grupo10
 */
public class AlumnoData {
    private Connection conx = null;

    public AlumnoData(MiConexion conexion) {
        this.conx = conexion.buscarConexion();
    }
    
    public void guardarAlumno(Alumno alu) {  //INSERT INTO
        String query = "INSERT INTO alumno(nombre, apellido, fechNac, dni, activo) VALUES(?,?,?,?,?)"; //"?" Comodines para reutilizar query

        try {
            PreparedStatement ps = conx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setDate(3, Date.valueOf(alu.getFechaNac()));
            ps.setInt(4, alu.getDni());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alu.setIdAlumno(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener ID");
                ps.close();
            }
        } catch (SQLException excep) {
            System.out.println("WTF???");
        }
    }
    
    public Alumno buscarAlumno(int id){   //SELECT 1 ALUMNO
        Alumno alu= new Alumno();
        return alu;        
    }
    
    public List<Alumno> listarAlumnos(){    //SELECT * Alumnos
        List<Alumno> alu= new List<Alumno>();
        return alu;
    }
    
    public void actualizarAlumno(Alumno alu){ //UPDATE SET
        alu.setActivo(true);    //cambiar        
    }
    public void borrarAlumno(int id){   //UPDATE SET / DELETE
        Alumno alu= new Alumno();
        alu.setActivo(false);   //cambiar
    }
}
