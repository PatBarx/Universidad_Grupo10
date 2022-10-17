package Entidades;

import Data.MiConexion;
import java.time.LocalDate;

/**
 * @author Grupo 10
 */
public class Universidad_Grupo10 {

    public static void main(String[] args) {
        System.out.println("estos son cambios");               
        LocalDate fecha = LocalDate.now();
        
        MiConexion conect = new MiConexion("jdbc:mysql://localhost/tp_universidad", "root", "");
        //conect.buscarConexion();  //prueba de funcionamiento 
        
    }
}
