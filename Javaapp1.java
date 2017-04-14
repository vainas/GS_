/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import User.Palabra;
import java.sql.*;
import com.intersys.jdbc.*;
import com.intersys.objects.*;
import java.util.Iterator;
import java.util.Map;
import util.*;
/**
 *
 * @author vainas
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, CacheException{
        CacheDataSource ds = new CacheDataSource();
        String url = "jdbc:Cache://localhost:1972/USER";
        String usuario = "vainas";
        String password = "123456789A";
        ds.setURL(url);
        ds.setUser(usuario);
        ds.setPassword(password);
        Connection conn = ds.getConnection(); 
        Database dbconn = CacheDatabase.getDatabase(conn);
        //Palabra palabra = new Palabra(dbconn);
        //String Nombre = UtilConsola.leerCadena("Nombre : ", true);
        //palabra.setNombre(Nombre);
        //palabra._save();
        
        String query = "SELECT ID FROM Palabra WHERE DNI=?";
        PreparedStatement ps = conn.prepareStatement(query);
        String dni = UtilConsola.leerCadena("dni : ", true);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            Palabra palabra = (Palabra)Palabra._open(dbconn, new Id(id));
            String traduc = UtilConsola.leerCadena("traduccion : ", true);
            String idiom = UtilConsola.leerCadena("idioma : ", true);
            palabra.getarrayTraduccion().put(idiom, traduc);
            palabra._save();
            /*
            Map arrayTraduccion = palabra.getarrayTraduccion();
            Iterator it = arrayTraduccion.keySet().iterator();
            while(it.hasNext()){
                Integer key = (Integer) it.next();
                System.out.println("Clave: " + key + " -> Valor: " + arrayTraduccion.get(key));
            }
            System.out.println(palabra.getId());
            */
        }
        
    }
}
