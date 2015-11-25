package com.servicio.servicio;

public class main_prueba {

	public main_prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resultado;
		funciones_servicio prueba = new funciones_servicio();
		resultado = prueba.login("cachetes", "valerys1");
		System.out.println("resultado: "+resultado);
	}

}
