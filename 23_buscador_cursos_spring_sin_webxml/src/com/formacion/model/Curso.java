package com.formacion.model;

public class Curso {
	private String nombre;
	private String tema;
	private int duracion;
	public Curso(String nombre, String tema, int duracion) {
		super();
		this.nombre = nombre;
		this.tema = tema;
		this.duracion = duracion;
	}
	public Curso() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
}
