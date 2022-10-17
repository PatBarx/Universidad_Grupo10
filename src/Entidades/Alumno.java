package Entidades;

import java.time.LocalDate;
/**
 * @author Grupo10
 */
public class Alumno {
    int idAlumno = -1;  //valor inválido xq lo asignara la BD (Autincrement)
    String nombre;      //VARCHAR
    String apellido;    //VARCHAR
    LocalDate fechaNac; //parsear a DATETIME
    int dni;
    boolean activo;     //TINYINT

    public Alumno(int idAlumno, String nombre, String apellido, LocalDate fechaNac, int dni, boolean activo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.activo = activo;
    }

    public Alumno(String nombre, String apellido, LocalDate fechaNac, int dni, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.activo = activo;
    }

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ID_Alumno: " + idAlumno + "\tDNI: " + dni + "\nApellido y Nombre: " + apellido + ", " + nombre +  "\nFecha de Nacimiento: " + fechaNac + "\nESTADO: " + activo + '.';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        return true;
    }     
}
