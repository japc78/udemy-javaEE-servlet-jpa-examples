package com.formacion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacion.model.Curso;

@Controller
public class CursosController {
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
	public String buscador(@RequestParam("tema") String tema, HttpServletRequest request) {
		List<Curso> resultado=cursos.stream()
		.filter(c->c.getTema().equals(tema))
		.collect(Collectors.toList());
		request.setAttribute("cursos", resultado);
		return "cursos";
	}
}
