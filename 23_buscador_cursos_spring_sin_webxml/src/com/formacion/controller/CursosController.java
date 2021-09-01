package com.formacion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacion.model.Curso;
import com.formacion.service.CursosService;

@Controller
public class CursosController {
	//inyecta una instancia del servicio
	@Autowired
	CursosService service;
	List<Curso> cursos;
	public CursosController() {
		cursos=new ArrayList<>();
		cursos.add(new Curso("Java","Programación",50));
		cursos.add(new Curso("Angular","Programación",30));
		cursos.add(new Curso("Linux","Sistemas",40));
		cursos.add(new Curso("Big Data","Datos",30));
		cursos.add(new Curso("SQL","Datos",20));
	}
	
	
	@PostMapping(value="buscar")
	public String buscador(@RequestParam("tema") String tema,
							HttpServletRequest request) {
		List<Curso> encontrados=service.buscarCursosTema(tema);
		//guarda en un atributo de petición
		//la lista de cursos encontrados del tema
		request.setAttribute("cursos", encontrados);
		return "cursos";
	}
}
