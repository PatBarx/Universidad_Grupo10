package Entidades;

import Data.AlumnoData;
import Data.CursadaData;
import Data.MateriaData;
import Data.MiConexion;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        CursadaData curs=new CursadaData(conec,adt,mat);
        //System.out.println(conec.getUrl());
        //System.out.println(conec.getUsuario());
        //System.out.println(conec.getPass());               
        
        //LocalDate fechaNac = LocalDate.of(1972,05,23);
        //Alumno alu1=new Alumno(2,"osvaldo","aguero",LocalDate.of(2000,8,11),23334566,true);
        Alumno alu1=new Alumno(6,"pato","barcos",LocalDate.of(1981,9,23),2223523,true);
        Materia ma=new Materia(14,"WEB",5,true);
        Cursada cu=new Cursada(alu1,ma,8);
        
        //---GUARDAR CURSADA:
        curs.guardarCursada(cu);
        //---ACTUALIZAR CURSADA:
        //curs.actualizarNota(6, 4, 9);
        //---BORRAR CURSADA:
        //curs.borrarCursada(6);

        //---GUARDAR MATERIA:
        //mat.guardarMateria(ma);
        //---BUSCAR MATERIA:
        //System.out.println( mat.buscarMateria(ma.getIdMateria()));
        //---BORRAR MATERIA:
        //mat.borrarMateria(ma.getIdMateria());
        //---ACTUALIZAR MATERIA:
        //mat.actualizarMateria(ma);

        //---GUARDAR ALUMNO:
        //adt.guardarAlumno(alu1);
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
        //---LISTAR y MOSTRAR ALUMNOS:
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("MATERIAS EN LAS QUE ESTA INSCRIPTO EL ALUMNO:");
        ArrayList<Materia>materias =curs.inscripcionMateria(alu1);
        for (Materia aux : materias) {
        //--JOptionPane.showMessageDialog(null," anio= "+aux.getAnio()+" nombre= "+aux.getNombre());
        System.out.println(" anio= "+aux.getAnio()+" nombre= "+aux.getNombre());
        // System.out.println(" idCursada= "+aux.getIdCursada()+" idAlumno= "+aux.getAl().getIdAlumno()+" idMateria= "+aux.getMa().getIdMateria()+" nota= "+aux.getNota());
        }
        
        //---LISTAR y MOSTRAR :
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("MATERIAS EN LAS QUE NO ESTA INSCRIPTO EL ALUMNO:");
        ArrayList<Materia>mater = curs.noInscripcionMateria(alu1);
        for (Materia aux : mater) {
        //-- JOptionPane.showMessageDialog(null," anio= "+aux.getAnio()+" nombre= "+aux.getNombre());
        System.out.println(" anio= "+aux.getAnio()+" nombre= "+aux.getNombre());
        // System.out.println(" idCursada= "+aux.getIdCursada()+" idAlumno= "+aux.getAl().getIdAlumno()+" idMateria= "+aux.getMa().getIdMateria()+" nota= "+aux.getNota());
        }   
                 
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("ALUMNOS que estan inscriptos en la materia:");
        ArrayList<Alumno>alumnos =curs.inscripcionAlumno(ma);
        for (Alumno aux : alumnos) {
        //-- JOptionPane.showMessageDialog(null," nombre= "+aux.getNombre()+" apellido= "+aux.getApellido());
        System.out.println(" nombre= "+aux.getNombre()+" apellido= "+aux.getApellido());
        }
        System.out.println("########################################################");
        
       
        
        System.out.println(curs.obtenerCursada(1, 2));
        
    }
}
