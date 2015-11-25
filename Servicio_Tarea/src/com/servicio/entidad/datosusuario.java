package com.servicio.entidad;

public class datosusuario {

	private int id_datosusuario;
	private int id_usuario;
	private String usuario;
	private String contrasena;
	private String estado;
	
	
	
	public int getId_datosusuario() {
		return id_datosusuario;
	}



	public void setId_datosusuario(int id_datosusuario) {
		this.id_datosusuario = id_datosusuario;
	}



	public int getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public datosusuario(int id_datosusuario, int id_usuario, String usuario, String contrasena, String estado) {
		super();
		this.id_datosusuario = id_datosusuario;
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.estado = estado;
	}



	public datosusuario() {
		// TODO Auto-generated constructor stub
	}

}
