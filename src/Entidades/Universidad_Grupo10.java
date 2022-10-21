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
        System.out.println("---   1,2,3 Probando Cambios   ---\n");               
        //LocalDate fecha = LocalDate.now();
        
        MiConexion conec = new MiConexion("jdbc:mysql://localhost/tp_universidad", "root", "");
        //conect.buscarConexion();  //prueba de funcionamiento 
        AlumnoData adt =new AlumnoData(conec);
        MateriaData mat=new MateriaData(conec);
        //System.out.println(conec.getUrl());
        //System.out.println(conec.getUsuario());
        //System.out.println(conec.getPass());               
        
        //LocalDate fechaNac = LocalDate.of(1972,05,23);
        Alumno al=new Alumno(5,"daniel","de la iglesia",LocalDate.of(1972,05,23),2261523,true);
        Materia ma=new Materia("INGLES",3,true);

        //---GUARDAR MATERIA:
        //mat.guardarMateria(ma);
        //---BUSCAR MATERIA:
        //System.out.println( mat.buscarMateria(ma.getIdMateria()));
        //---BORRAR MATERIA:
        //mat.borrarMateria(ma.getIdMateria());
        //---ACTUALIZAR MATERIA:
        //mat.actualizarMateria(ma);

        //---GUARDAR ALUMNO:
        //adt.guardarAlumno(al);
        //---ACTUALIZAR ALUMNO:
        //adt.actualizarAlumno(al);
        //---BUSCAR ALUMNO:
        //System.out.println(adt.buscarAlumno(al.getIdAlumno()));
        //---BORRAR ALUMNO:
        //adt.borrarAlumno(al.getIdAlumno());

        //---LISTAR y MOSTRAR ALUMNOS:
        //---Probar listar alumnos
        ArrayList<Alumno>lista =adt.listarAlumnos();
        
        for (Alumno alu : lista) {
            System.out.println("-DNI: \t"+alu.getDni()
                    +"\t| -Legajo-Nº: " + alu.getIdAlumno()
                    +"\n-Apellido: "+alu.getApellido()
                    + "\t| -Nombre: "+alu.getNombre()
                    +"\n-Fecha de nacimiento: \t"+alu.getFechaNac()
                    + "\n");
            }
        System.out.println("-------------------------------------------------");
        
        //---LISTAR y MOSTRAR MATERIAS:
        ArrayList<Materia>mate =mat.listarMateria();

        for (Materia aux : mate) {
            System.out.println("Año: "+aux.getAnio()
                    +"\t| -Nombre:   "+aux.getNombre()
                    +"\t| -Activo: \t"+aux.isActivo());
        }
    }
}
