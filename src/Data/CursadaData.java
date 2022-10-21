package Data;

import Entidades.Alumno;
import Entidades.Cursada;
import Entidades.Materia;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Grupo10
 */
public class CursadaData {
    
    private Connection conx = null;

    public CursadaData(MiConexion conexion) {
        this.conx = conexion.buscarConexion();
    }
    
    
    public void guardarInscripcion(Cursada insc){
        System.out.println("asd");
        
        //JOptionPane.showMessageDialog(null, "INSCRIPCION Data Error: " + excep);
    }
    
    public void obtenerInscripcion(Alumno alumno ,Materia materia){//Inscripcion
        
    }
    
    public boolean borrarInscripcion(Alumno alumno ,Materia materia){
    
    }
    
    public void actualizarNota(Alumno alumno ,Materia materia , nota){
    
    }
    
    public ArrayList<Materia> obtenerMateriasNoInscriptos(Alumno alumno){ //List Materia>
        
    }
    
    public ArrayList<Alumno> obtnerAlumnosInscriptos(Materia materia){ //List<Alumno>
        
    }    
}
