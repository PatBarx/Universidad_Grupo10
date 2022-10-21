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
        String query = "INSERT INTO alumno(nombre, apellido,fechaNac, dni, activo) VALUES(?,?,?,?,?)"; //"?" Comodines para reutilizar query

        try {
            PreparedStatement ps = conx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setDate(3, Date.valueOf(alu.getFechaNac()));
            ps.setLong(4, alu.getDni());
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
            System.out.println(excep);
        }
    }
    
    public Alumno buscarAlumno(int id){   //SELECT 1 ALUMNO
               //SELECT 1 ALUMNO
        Alumno alu= null;;
        String sql="SELECT * FROM alumno WHERE idAlumno=?";
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
          ArrayList<Alumno>alumnos =new ArrayList();
    
    try{
    String sql = " SELECT *  FROM alumno WHERE activo = 1 ;";
    PreparedStatement pst = conx.prepareStatement(sql);
    ResultSet resultSet = pst.executeQuery();
    
    Alumno alu;
    
    while(resultSet.next()){
        
        alu=new Alumno();
        alu.setIdAlumno(resultSet.getInt("idAlumno"));
        alu.setApellido(resultSet.getString("apellido"));
        alu.setNombre(resultSet.getString("nombre"));
        alu.setFechaNac(resultSet.getDate("fechaNac").toLocalDate());
        alu.setDni(resultSet.getInt("dni"));
        alu.setActivo(resultSet.getBoolean("activo"));
        
        alumnos.add(alu);
    }
    pst.close();
     }catch(SQLException e){

JOptionPane.showMessageDialog(null, "error al obtner alumno");
}
  return  alumnos;
    }
    
    public void actualizarAlumno(Alumno alu){ //UPDATE SET
            //UPDATE SET
        String query="UPDATE alumno SET nombre=?, apellido=?, fechaNac=?, dni=?, activo=? WHERE idAlumno=?";
        //System.out.println(query);
        try {
        PreparedStatement ps= conx.prepareStatement(query);
        
         ps.setString(1, alu.getNombre());
            ps.setString(2, alu.getApellido());
            ps.setDate(3, Date.valueOf(alu.getFechaNac()));
            ps.setLong(4, alu.getDni());
            ps.setBoolean(5, true);
            ps.setInt(6,alu.getIdAlumno());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void borrarAlumno(int id){   //UPDATE SET / DELETE
     
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


    }
}

