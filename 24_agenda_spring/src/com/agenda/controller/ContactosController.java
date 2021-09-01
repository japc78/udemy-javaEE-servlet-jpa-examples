package com.agenda.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agenda.model.Contacto;
import com.agenda.service.ContactosService;

@Controller
public class ContactosController {
	@Autowired
	ContactosService service;
	
	@PostMapping("alta")
	public String nuevoContacto(@RequestParam("nombre") String nombre,
			@RequestParam("email") String email,
			@RequestParam("telefono") int telefono) {
		Contacto contacto=new Contacto(0,nombre,email,telefono);
		if(!service.nuevoContacto(contacto)) {
			return "repetido";
		}
		return "inicio";
	}
	@GetMapping(value="recuperar")
	public String recuperarContactos(HttpServletRequest request) {
		request.setAttribute("contactos", service.obtenerContactos());
		return "contactos";
	}
	@GetMapping(value="eliminar")
	public String eliminarContacto(@RequestParam("idContacto") int idContacto) {
		if(!service.eliminarContacto(idContacto)) {
			return "noexistente";
		}
		return "forward:/recuperar";
	}
}
