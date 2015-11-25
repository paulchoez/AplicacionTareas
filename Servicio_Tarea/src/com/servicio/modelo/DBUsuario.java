package com.servicio.modelo;

import java.sql.Connection;
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

}
