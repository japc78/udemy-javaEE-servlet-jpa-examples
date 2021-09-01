package com.formacion.controller;

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
	@Autowired
	CursosService service;
	
	@PostMapping(value="buscar")
	public String buscador(@RequestParam("tema") String tema, HttpServletRequest request) {
		List<Curso> cursos=service.buscadorCursos(tema);
		request.setAttribute("cursos", cursos);
		return "cursos";
	}
}
