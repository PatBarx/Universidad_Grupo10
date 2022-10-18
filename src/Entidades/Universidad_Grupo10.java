package Entidades;

import Data.AlumnoData;
import Data.MiConexion;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Grupo 10
 */
public class Universidad_Grupo10 {

    public static void main(String[] args) {
        System.out.println("estos son cambios");               
        LocalDate fecha = LocalDate.now();
        
        MiConexion conect = new MiConexion("jdbc:mysql://localhost/tp_universidad", "root", "");
        //conect.buscarConexion();  //prueba de funcionamiento 
               AlumnoData adt =new AlumnoData(conect);




//esto para probar listar alumnos
    ArrayList<Alumno>lista =adt.listarAlumno();
    
        for (Alumno alu : lista) {
            System.out.println("dni"+alu.getDni());
             System.out.println("apellido"+alu.getApellido());
             System.out.println("nombre"+alu.getNombre());
        }
    }
}
