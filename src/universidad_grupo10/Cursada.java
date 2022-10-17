/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_grupo10;

/**
 *
 * @author Usuario
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
        return "Cursada{" + "idCursada=" + idCursada + ", al=" + al + ", ma=" + ma + ", nota=" + nota + '}';
    }
   
    
}
