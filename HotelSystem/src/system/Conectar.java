/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leslie Callejas
 */
public class Conectar {
    public static java.sql.Connection conectar;
 
   public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "clientes","root","");
        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
        }
        return conectar;
    }
    
    public void closeConnection() {
        try {
            conectar.close();
            java.lang.System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void insertData(String table_name,String Nombre, String Apellidos, String CiudadDeOrigen,String Telefono, String TipoDeHabitacion, String NumDeHabitacion,String FormaDePago) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
		    + "\"" + Nombre + "\", "
                    + "\"" + Apellidos + "\", "
                    + "\"" + CiudadDeOrigen + "\", "
                    + "\"" + Telefono + "\", "
		    + "\"" + TipoDeHabitacion + "\", "
		    + "\"" + NumDeHabitacion + "\", "
                    + "\"" + FormaDePago + "\")";
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
	    
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    
    public void deleteRecord(String table_name, String Nombre) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE Nombre = \"" + Nombre + "\"";
            Statement st = conectar.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            java.lang.System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    
}
