/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.*;
import modeloVO.UsuarioVO;
import util.*;
import java.util.logging.*;



/**
 *
 * @author jsebi
 */
public class UsuarioDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    
    private String usuId="", usuLogin="", usuPassword="";
    
    public UsuarioDAO(UsuarioVO usuVO){
        
        super();
        
        try {
            conexion = this.obtenerConexion();
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
            
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }


    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO usuario(usulogin,usupassword) VALUES(?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro()  {
        try {
            sql = "UPDATE usuario SET usulogin=?, usupassword=? WHERE usuid=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean iniciarSesion(String usuario, String clave){
        try {
            conexion=this.obtenerConexion();
            sql="SELECT * FROM usuario WHERE usulogin=? and usupassword=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if(mensajero.next()){
                operacion = true;
            }

        } catch (SQLException e) {
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    
       public boolean tipoRol(String Id){
        try {
            
            conexion= this.obtenerConexion();
            sql="SELECT rol.ROLTIPO FROM usuario INNER JOIN usuario_rol ON usuario.USUID = usuario_rol.USUID INNER JOIN rol ON usuario_rol.ROLID= rol.ROLID WHERE usuario.USUID=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, Id);
            
            mensajero = puente.executeQuery();
            
            if(mensajero.next()){
                operacion = true;
                
            }
            
        } catch (SQLException e) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
}
