package Data;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public Alumno buscarAlumno(int id){   
        //SELECT 1 ALUMNO
        Alumno alu= null;;
        String sql="SELECT * FROM alumno WHERE id=?";
        PreparedStatement ps;
       try { 
        ps=conx.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            alu=new Alumno();
            alu.setIdAlumno(rs.getInt("idAlumno"));
            alu.setNombre(rs.getString("nombre"));
            alu.setApellido(rs.getString("apellido"));
            alu.setFechaNac(rs.getDate("fechaNac").toLocalDate());
            alu.setDni(rs.getInt("dni"));
            alu.setActivo(rs.getBoolean("activo"));
           
            
            
        }
        
    } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return alu;
    }
       
    public ArrayList<Alumno> listarAlumnos(){    //SELECT * Alumnos
        ArrayList<Alumno> alu= new ArrayList();
        return alu;
    }
    
    public void actualizarAlumno(Alumno alu){ 
        //UPDATE SET
        String query="UPDATE alumno SET nombre=?, apellido=?, fechNac=?, dni=?, activo=? WHERE id=?";
        try {
        PreparedStatement ps= conx.prepareStatement(query);
        
         ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setDate(3, Date.valueOf(alu.getFechaNac()));
            ps.setInt(4, alu.getDni());
            ps.setBoolean(5, true);
            ps.setInt(6,alu.getIdAlumno());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public boolean borrarAlumno(int id){

    boolean borrado=false;
    
    String sql ="UPDATE alumno SET activo = 0 WHERE idAlumno = ?";
    try{
    PreparedStatement pts =conx.prepareStatement(sql);
    pts.setInt(1, id);
    
    if(pts.executeUpdate()!=0){
    
    borrado=true;
    
    }
    pts.close();
    }catch(SQLException e){
    
     JOptionPane.showMessageDialog(null, "error al borrar alumno");
    
    
    }

return borrado;
} 
    }

