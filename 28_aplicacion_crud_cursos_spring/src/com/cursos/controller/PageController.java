package com.cursos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("toEliminar")
	public String paraEliminar(HttpServletRequest request) {
		request.setAttribute("url", "eliminar");
		return "buscador";
	}
	@GetMapping(value="toRecuperar")
	public String paraRecuperar(HttpServletRequest request) {
		request.setAttribute("url", "recuperar");
		return "buscador";
	}
	@GetMapping(value="toActualizar")
	public String paraActualizar(HttpServletRequest request) {
		request.setAttribute("url", "recuperarActualizar");
		return "buscador";
	}
}
