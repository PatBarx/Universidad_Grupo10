package Entidades;

/**
 * @author Grupo10
 */
public class Cursada {
    int idCursada;
    Alumno al;
    Materia ma;
   double nota;

    public Cursada(int idCursada, Alumno al, Materia ma, double nota) {
        this.idCursada = idCursada;
        this.al = al;
        this.ma = ma;
        this.nota = nota;
    }

    public Cursada(Alumno al, Materia ma, double nota) {
        this.al = al;
        this.ma = ma;
        this.nota = nota;
    }

    public Cursada() {
    }

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public Alumno getAl() {
        return al;
    }

    public void setAl(Alumno al) {
        this.al = al;
    }

    public Materia getMa() {
        return ma;
    }

    public void setMa(Materia ma) {
        this.ma = ma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripciones de Cursada: " + "\nID_Cursada: " + idCursada + "\n Alumno: " + al + "\t Materia: " + ma + "\tNota: " + nota + '.';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idCursada;
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
        final Cursada other = (Cursada) obj;
        if (this.idCursada != other.idCursada) {
            return false;
        }
        return true;
    }
}
