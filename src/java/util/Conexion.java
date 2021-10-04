/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;

/**
 *
 * @author jsebi
 */
public class Conexion {
   
    private String driver,user,password,nameDB,urlDB;
    private Connection conexion;
    
    public Conexion(){
        driver="com.mysql.jdbc.Driver";
        user="root";
        password="";
        nameDB="javaej1";
        urlDB="jdbc:mysql://localhost:3306/"+nameDB;
        
        try{
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlDB,user,password);
            System.out.println("Conexion establecida");
        }catch(Exception e){
            System.out.println("Error al conectarse " + e.toString());
        }
    }
    
    public Connection obtenerConexion(){
        
        return conexion;
        
    }
    
    public Connection cerrarConexion() throws SQLException{
        
       conexion.close();
       conexion = null;
       return conexion;
        
    }
    
    public static void main(String[] args) {
        
        new Conexion();
        
    }
            
}
