package com.servicio.entidad;

public class usuario {
     private int id_usuario;
     private int id_tipousuario;
     private int id_persona;
     private String estado;
     
     
	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public int getId_tipousuario() {
		return id_tipousuario;
	}


	public void setId_tipousuario(int id_tipousuario) {
		this.id_tipousuario = id_tipousuario;
	}


	public int getId_persona() {
		return id_persona;
	}


	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public usuario() {
		// TODO Auto-generated constructor stub
		
	}

	public usuario(int id_usuario, int id_tipousuario, int id_persona, String estado) {
		super();
		this.id_usuario = id_usuario;
		this.id_tipousuario = id_tipousuario;
		this.id_persona = id_persona;
		this.estado = estado;
	}


}
