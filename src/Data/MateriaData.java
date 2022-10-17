package Data;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Grupo10
 */
public class MateriaData {
              private Connection conx = null;

    public MateriaData(MiConexion conexion) {
        this.conx = conexion.buscarConexion();
    }
    
    public void guardarMateria(Materia mate) {  //INSERT INTO
        String query = "INSERT INTO materia(nombre, anio, activo) VALUES(?,?,?)"; //"?" Comodines para reutilizar query

        try {
            PreparedStatement ps = conx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnio());
            ps.setBoolean(3,mate.isActivo());
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mate.setIdMateria(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener ID");
                ps.close();
            }
        } catch (SQLException excep) {
            System.out.println("WTF???");
        }
    }
    
    public Materia buscarMateria(int id){   //SELECT 1 ALUMNO
        Materia mate= new Materia();
        return mate;        
    }
    
    public ArrayList<Materia> listarMateria(){    //SELECT * Alumnos
        ArrayList<Materia> mate= new ArrayList();
        return mate;
    }
    
    public void actualizarAlumno(Materia mate){ //UPDATE SET
        mate.setActivo(true);    //cambiar        
    }
    public void borrarAlumno(int id){   //UPDATE SET / DELETE
        Materia mate= new Materia();
        mate.setActivo(false);   //cambiar
    }
    
}
