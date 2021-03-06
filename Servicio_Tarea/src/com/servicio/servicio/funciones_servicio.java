package com.servicio.servicio;

import com.servicio.modelo.DBDepartamento;
import com.servicio.modelo.DBUsuario;

public class funciones_servicio {

	public String login(String usuario, String contrasena){
		DBUsuario dbusuario = new DBUsuario();
		return dbusuario.login(usuario, contrasena);
	}
	
	public int id_tipo_usuario(String usuario, String contrasena){
		DBUsuario dbusuario = new DBUsuario();
		return dbusuario.id_tipo_usuario(usuario, contrasena);
	}
	
	public int id_departamento(String departamento){
		DBDepartamento dbdepartamento = new DBDepartamento();
		return dbdepartamento.id_departamento(departamento);
	}

	public String registrousuario(String nombres,Integer id_departamento, String apellidos, String cedula, String email, String direccion, 
			Integer id_tipousuario, String usuarios, String contraseņa){
		String resultado = "0";
		
		DBUsuario dbusuario = new DBUsuario();
		Integer r = dbusuario.nuevoUsuario(nombres,id_departamento, apellidos, cedula, email, direccion, id_tipousuario, usuarios, contraseņa);
		// 1: se ah agregado correctamente
		if(r==1){
			resultado= "1";
		}
		//2: el usuario ya esta registrado
		if(r==2){
			resultado= "2";
		}
		//0: no se pudo ingresar
		if(r==0){
			resultado="0";
		}
		return resultado;
	}
	
	public int validar_cedula(String cedula){
		DBUsuario dbusuario = new DBUsuario();
		return dbusuario.validar_cedula(cedula);
	}
	
	public boolean usuario(String usuario){
		DBUsuario dbusuario = new DBUsuario();
		return dbusuario.validarIngresousuario(""+usuario);
	}

}
