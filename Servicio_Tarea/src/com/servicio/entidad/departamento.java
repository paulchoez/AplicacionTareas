package com.servicio.entidad;

public class departamento {

	
	private int id_tipodepartamento;
	private String descripcion;
	private String estado;
	
	
	
	public int getId_tipodepartamento() {
		return id_tipodepartamento;
	}



	public void setId_tipodepartamento(int id_tipodepartamento) {
		this.id_tipodepartamento = id_tipodepartamento;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public departamento(int id_tipodepartamento, String descripcion, String estado) {
		super();
		this.id_tipodepartamento = id_tipodepartamento;
		this.descripcion = descripcion;
		this.estado = estado;
	}



	public departamento() {
		// TODO Auto-generated constructor stub
	}

}
