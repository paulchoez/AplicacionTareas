package com.servicio.servicio;

public class main_prueba {

	public main_prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resultado;
		int respuesta;
		funciones_servicio prueba = new funciones_servicio();
		//resultado = prueba.login("cachetes", "valerys1");
		//System.out.println("resultado: "+resultado);
		//resultado = prueba.registrousuario("pedro", 1, "panchana","2400387748", "ppanchana@gmail.com", "santa elena", 1, "pedro", "12345");
		//System.out.println("resultado: "+resultado);
		//respuesta = prueba.validar_cedula("2405387748");
		//respuesta = prueba.id_tipo_usuario("pedro", "1235");
		respuesta = prueba.id_departamento("Sistem");
		System.out.println("resultado: "+respuesta);
	}

}
	