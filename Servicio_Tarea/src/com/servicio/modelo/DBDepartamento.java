package com.servicio.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDepartamento {
	public int id_departamento(String departamento){
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
			resultado = state.executeQuery("SELECT idTipoDepartamento FROM departamento where estado = 'A'"
					+ " and descripcion = '"+departamento+"' ;");
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

}
