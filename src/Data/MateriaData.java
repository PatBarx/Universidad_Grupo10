package Data;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                //SELECT 1 ALUMNO
        Materia mate= null;;
        String sql="SELECT * FROM alumno WHERE id=?";
        PreparedStatement ps;
       try { 
        ps=conx.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            mate=new Materia();
            mate.setIdMateria(rs.getInt("idMateria"));
            mate.setNombre(rs.getString("nombre"));
            mate.setAnio(rs.getInt("anio"));
            mate.setActivo(rs.getBoolean("activo"));
           
            
            
        }
        
    } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return mate;         
    }
    
    public ArrayList<Materia> listarMateria(){    //SELECT * Alumnos
        ArrayList<Materia> mate= new ArrayList();
        return mate;
    }
    
    public void actualizarAlumno(Materia mate){ //UPDATE SET
                     //UPDATE SET
        String query="UPDATE alumno SET nombre=?, anio=?, activo=? WHERE id=?";
        try {
        PreparedStatement ps= conx.prepareStatement(query);
        
            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnio());
            ps.setBoolean(3,mate.isActivo());
            ps.setInt(4,mate.getIdMateria());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }   //cambiar        
    }
    public void borrarMateria(int id){   //UPDATE SET / DELETE
        Materia mate= new Materia();
        mate.setActivo(false);   //cambiar
    }
    
}
