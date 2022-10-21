package Entidades;

import Data.AlumnoData;
import Data.MateriaData;
import Data.MiConexion;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Grupo 10
 */
public class Universidad_Grupo10 {

    public static void main(String[] args) {
                 System.out.println("estos son cambios");               
        //LocalDate fecha = LocalDate.now();
        
        MiConexion conec = new MiConexion("jdbc:mysql://localhost/tp_universidad", "root", "");
        //conect.buscarConexion();  //prueba de funcionamiento 
               AlumnoData adt =new AlumnoData(conec);
               MateriaData mat=new MateriaData(conec);
               //System.out.println(conec.getUrl());
               //System.out.println(conec.getUsuario());
               //System.out.println(conec.getPass());




//esto para probar listar alumnos
    ArrayList<Alumno>lista =adt.listarAlumnos();
    //LocalDate fechaNac = LocalDate.of(1972,05,23);
  Alumno al=new Alumno(17,"daniel","de la iglesia",LocalDate.of(1972,05,23),2261523,true);
  Materia ma=new Materia(6,"biologia2",5,true);
  
 //mat.guardarMateria(ma);
//System.out.println( mat.buscarMateria(6));

//mat.borrarMateria(ma.getIdMateria());
mat.actualizarMateria(ma);
   //adt.guardarAlumno(al);
  // adt.actualizarAlumno(al);
        //System.out.println(adt.buscarAlumno(al.getIdAlumno()));
    //adt.borrarAlumno(al.getIdAlumno());
        for (Alumno alu : lista) {
            System.out.println("dni= "+alu.getDni()+" apellido= "+alu.getApellido()+ " nombre= "+alu.getNombre()+" fecha de nacimiento= "+alu.getFechaNac());
           
        }
        System.out.println("----------------------------------------------------------");
         ArrayList<Materia>mate =mat.listarMateria();
    
        for (Materia aux : mate) {
            System.out.println(" anio= "+aux.getAnio()+" nombre= "+aux.getNombre()+" activo= "+aux.isActivo());
           
        }
    }
}
