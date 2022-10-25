package Data;

import Entidades.Alumno;
import Entidades.Cursada;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Grupo10
 */
public class CursadaData {

    private Connection con = null;

    public CursadaData(MiConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    public void guardarCursada(Cursada cur) {
        String query = "INSERT INTO cursada(idAlumno, IdMateria, nota) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cur.getAl().getIdAlumno());
            ps.setInt(2, cur.getMa().getIdMateria());
            ps.setDouble(3, cur.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cur.setIdCursada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "CursadaData Info: Carga Exitosa");
                System.out.println("CursadaData Info: Carga Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "CursadaData Info: No se pudo obtener ID");
                System.out.println("CursadaData Info: No se pudo obtener ID");
            }
            ps.close();
        } catch (SQLException excep) {
            JOptionPane.showMessageDialog(null, "CursadaData Info: no se pudo cargar" + excep);
            System.out.println("CursadaData Info: no se pudo cargar");
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String query = "update cursada set nota=? where idAlumno=? and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            ps.setDouble(1, nota);

            // ps.executeUpdate();
            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "CursadaData Info: actualizacion Exitosa");
                System.out.println("CursadaData Info: actualizacion Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "CursadaData Info: NO PUDO MODIFICARSE");
                System.out.println("CursadaData Info: NO PUDO MODIFICARSE");
            }
            System.out.println("eu: " + ps.executeUpdate());//comprobacion de Execute u..

            ps.close();
        } catch (SQLException excep) {
            System.out.println("LA nota no pudo modificarse  - " + excep);
        }
    }

    public void borrarCursada(int idCursada) {
        String query = "DELETE FROM `cursada` WHERE idCursada=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idCursada);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "CursadaData Info: Borrado exitoso");
                System.out.println("CursadaData Info: Borrado exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "CursadaData Info: NO PUDO BORRARSE");
                System.out.println("CursadaData Info: NO PUDO BORRARSE");
            }
            System.out.println("eu: " + ps.executeUpdate());//comprobacion de Execute u..

            ps.close();
        } catch (SQLException excep) {
            System.out.println("no pudo borrase");
        }
    }

    public ArrayList<Materia> inscripcionMateria(Alumno al) {    //SELECT * Alumnos
        ArrayList<Materia> materias = new ArrayList();
        String sql = " SELECT materia.nombre,materia.anio FROM materia,cursada,alumno WHERE "
                + "materia.idMateria=cursada.idMateria and alumno.idAlumno=cursada.idAlumno and alumno.idAlumno=? ";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, al.getIdAlumno());
            ResultSet rs = pst.executeQuery();
            Materia mate;

            while (rs.next()) {
                mate = new Materia();
                //mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                //mate.setActivo(rs.getBoolean("activo"));
                materias.add(mate);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "error al obtner alumno");
        }
        return materias;
    }

    public ArrayList<Materia> noInscripcionMateria(Alumno al) {    //SELECT * Alumnos
        ArrayList<Materia> materias = new ArrayList();
        String sql = " SELECT materia.*FROM `materia`WHERE materia.idMateria NOT IN (SELECT idMateria FROM cursada WHERE idAlumno =? )";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, al.getIdAlumno());
            ResultSet rs = pst.executeQuery();
            Materia mate;

            while (rs.next()) {
                mate = new Materia();
                //mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                //mate.setActivo(rs.getBoolean("activo"));
                materias.add(mate);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "error al obtner alumno");
        }
        return materias;
    }

    public ArrayList<Alumno> inscripcionAlumno(Materia ma) {    //SELECT * Alumnos
        ArrayList<Alumno> alumnos = new ArrayList();
        String sql = " SELECT alumno.nombre ,alumno.apellido FROM materia,cursada,alumno WHERE "
                + "materia.idMateria=cursada.idMateria and alumno.idAlumno=cursada.idAlumno and materia.idMateria=? ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, ma.getIdMateria());
            ResultSet rs = pst.executeQuery();
            Alumno al;

            while (rs.next()) {
                al = new Alumno();
                //mate.setIdMateria(rs.getInt("idMateria"));
                al.setNombre(rs.getString("nombre"));
                al.setApellido(rs.getString("apellido"));
                //mate.setActivo(rs.getBoolean("activo"));
                alumnos.add(al);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "error al obtner alumno");
        }
        return alumnos;
    }
}
