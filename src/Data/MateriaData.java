package Data;

import Entidades.Materia;
import java.sql.Connection;
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
public class MateriaData {

    private Connection conx = null;

    public MateriaData(MiConexion conexion) {
        this.conx = conexion.buscarConexion();
    }

    public void guardarMateria(Materia mate) {  //INSERT INTO
        String query = "INSERT INTO materia(nombre, anio, activo) VALUES(?,?,?)"; //"?" Comodines para reutilizar query

        try {
            PreparedStatement ps = conx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnio());
            ps.setBoolean(3, mate.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
//            if (ps.executeUpdate() > 0) {
//                JOptionPane.showMessageDialog(null, "MateriaData Info: GUARDADO");
//            } else {
//                JOptionPane.showMessageDialog(null, "MateriaData Info: No se pudo Guardar");
//            }
            if (rs.next()) {
                mate.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "MateriaData Info: GUARDADO");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID");                
            }
            ps.close();
        } catch (SQLException excep) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    public Materia buscarMateria(int id) {   //SELECT 1 ALUMNO
        //SELECT 1 ALUMNO
        Materia mate = null;;
        String sql = "SELECT * FROM materia WHERE idMateria=?";
        PreparedStatement ps;
        try {
            ps = conx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setActivo(rs.getBoolean("activo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mate;
    }

    public ArrayList<Materia> listarMateria() {    //SELECT * Alumnos
        ArrayList<Materia> mater = new ArrayList();

        try {
            String sql = " SELECT *  FROM materia WHERE activo = 1 ;";
            PreparedStatement pst = conx.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            Materia mate;

            while (rs.next()) {

                mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setActivo(rs.getBoolean("activo"));

                mater.add(mate);
            }
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "error al obtner alumno");
        }
        return mater;
    }

    public void actualizarMateria(Materia mate) { //UPDATE SET
        //UPDATE SET
        String query = "UPDATE materia SET nombre=?, anio=?, activo=? WHERE idMateria=?";
        try {
            PreparedStatement ps = conx.prepareStatement(query);

            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnio());
            ps.setBoolean(3, mate.isActivo());
            ps.setInt(4, mate.getIdMateria());
            ps.executeUpdate();
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "MateriaData Info: ACTUALIZADO");
            } else {
                JOptionPane.showMessageDialog(null, "MateriaData Info: No se pudo actualizar");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean borrarMateria(int id) {   //UPDATE SET / DELETE

        boolean borrado = false;

        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ?";
        try {
            PreparedStatement pts = conx.prepareStatement(sql);
            pts.setInt(1, id);

            if (pts.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "MateriaData Info: Materia Borrada");
                borrado = true;
            }

            else {
                JOptionPane.showMessageDialog(null, "MateriaData Info: No se pudo Borrar");
            }
            pts.close();
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "error al borrar materia");

        }

        return borrado;
    }

}
