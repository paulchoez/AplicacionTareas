package com.servicio.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUsuario {

	public DBUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	public String login(String usuario, String contrasena){
		int cont = 0;
		String respuesta = "";
		ResultSet resultado = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
			return "error con la conexion a BD";
		}
		Statement state = null;
		try {
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery("SELECT tu.descripcion FROM datosusuarios du, tiposusuarios tu, usuarios u "
					+ "where u.estado = 'A' and tu.estado = 'A'and du.estado = 'A' and "
					+ "u.id_tipousuario = tu.id_tipousuario and du.id_usuario = u.id_usuario and"
					+ " du.usuario = '"+usuario+"' and du.contraseña = '"+contrasena+"';");
			while(resultado.next()){
				cont = cont + 1;
				respuesta = resultado.getString(1);
			}
			if(cont>0){
				return respuesta;
			}else{
				return "no existe ese usuario";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error de datos";
		}
	}

	public int id_tipo_usuario(String usuario, String contrasena){
		int id = 0;
		int cont = 0;
		ResultSet resultado = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
			return id;
		}
		Statement state = null;
		try {
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery("SELECT tu.id_tipousuario FROM datosusuarios du, tiposusuarios tu, usuarios u "
					+ "where u.estado = 'A' and tu.estado = 'A'and du.estado = 'A' and "
					+ "u.id_tipousuario = tu.id_tipousuario and du.id_usuario = u.id_usuario and"
					+ " du.usuario = '"+usuario+"' and du.contraseña = '"+contrasena+"';");
			while(resultado.next()){
				cont = cont + 1;
				id = resultado.getInt(1);
			}
			if(cont>0){
				return id;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public Integer nuevoUsuario(String nombres, Integer id_departamento, String apellidos, String cedula, String email, String direccion, Integer id_tipousuario, String alias, String dpassword){
		Integer resultado=0;
		
		DBManager dbmanager = new DBManager();
		Connection con = dbmanager.getConection();
		if (!validarIngresousuario(alias))
		{
		//Manejo de transaccion
		try {
			con.setAutoCommit(false);
			String sql = null;
			String encrypassword = dpassword;
			sql="CALL sp_ingresar_usuarios (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, nombres);
			pstm.setInt(2, id_departamento);
			pstm.setString(3, apellidos);
			pstm.setString(4, cedula);
			pstm.setString(5, email);
			pstm.setString(6, direccion);
			pstm.setInt(7, id_tipousuario);
			pstm.setString(8, alias);
			pstm.setString(9, encrypassword);
		
			
			//retorna el numero de filas afectadas
			int num = pstm.executeUpdate();
			//si hasta aqui todo ha ido bien commit a la transaccion
			if(num>0){
			con.commit();
			resultado = 1;
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado=0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}else{
			resultado=2;
			
		}
		return resultado;
	}

	public Boolean validarIngresousuario(String usuario){
        //busqueda de existencia de usuario 
        //conectarse a la red
       boolean existe = false;
        DBManager dbmanager = new DBManager();
        Connection con =dbmanager.getConection();
        if(con==null){
            System.out.println("error en conexion");
            return existe;
        }
         
        //sentencia a ejecutar
        Statement sentencia;
        //objeto para almacenar resultados
        ResultSet resultados;
        String sql = null;
     
        sql ="select * from datosusuarios as du where du.usuario= '"+usuario+"'"; 
       
        try{
        sentencia =con.createStatement();
        resultados=sentencia.executeQuery(sql);
        
        while(resultados.next()){
           existe=true;
        }
        
            
          }catch (SQLException e){
             
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
         
        try{
        con.close();
        }catch (SQLException e){
             
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return existe;
    }
	
	public int validar_cedula(String cedula){
		int respuesta = 0;
		DBManager dbmanager = new DBManager();
        Connection con =dbmanager.getConection();
        if(con==null){
            System.out.println("error en conexion");
            return respuesta;
        }
         
        //sentencia a ejecutar
        Statement sentencia;
        //objeto para almacenar resultados
        ResultSet resultados;
        String sql = null;
     
        sql ="select count(cedula) from personas where cedula= '"+cedula+"' and estado = 'A'"; 
       
        try{
        sentencia =con.createStatement();
        resultados=sentencia.executeQuery(sql);
        while(resultados.next()){
           respuesta = resultados.getInt(1);
        }
        
            
          }catch (SQLException e){
             
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
         
        try{
        con.close();
        }catch (SQLException e){
             
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
		return respuesta;
	}

}
