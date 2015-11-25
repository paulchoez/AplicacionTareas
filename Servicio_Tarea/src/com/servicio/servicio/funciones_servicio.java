package com.servicio.servicio;

import com.servicio.modelo.DBUsuario;

public class funciones_servicio {

	public String login(String usuario, String contrasena){
		DBUsuario dbusuario = new DBUsuario();
		return dbusuario.login(usuario, contrasena);
	}

}
