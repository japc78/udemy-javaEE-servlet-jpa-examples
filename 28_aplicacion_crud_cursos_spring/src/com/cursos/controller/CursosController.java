package com.cursos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursos.model.Curso;
import com.cursos.service.CursosService;

@Controller
public class CursosController {
	@Autowired
	CursosService service;
	@PostMapping("alta")
	public String altaCurso(@ModelAttribute Curso curso) {
		service.nuevoCurso(curso);
		return "menu";
	}
	@GetMapping("eliminar")
	public String eliminarCurso(@RequestParam("idCurso") int idCurso) {
		service.eliminarCurso(idCurso);
		return "menu";
	}
	@GetMapping("recuperar")
	public String recuperarCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		Curso curso=service.buscarCurso(idCurso);
		request.setAttribute("curso", curso);
		return "curso";
	}
	@GetMapping("recuperarActualizar")
	public String recuperarActualizarCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		Curso curso=service.buscarCurso(idCurso);
		request.setAttribute("curso", curso);
		return "cursoActualizar";
	}
	@PostMapping("actualizar")
	public String actualizarCurso(@ModelAttribute Curso curso) {
		if(service.buscarCurso(curso.getIdCurso())!=null) {
			service.actualizarCurso(curso);
		}
		return "menu";
	}
	@GetMapping("cursosDuracion")
	public String cursosPorDuracion(@RequestParam("duracion") int duracion, HttpServletRequest request){ 
		List<Curso> cursos=service.cursosDuracionMaxima(duracion);
		request.setAttribute("cursos", cursos);
		return "listaCursos";
	}
}
