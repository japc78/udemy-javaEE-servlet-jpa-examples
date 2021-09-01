package com.agenda.repository;

import java.util.List;

import com.agenda.model.Contacto;

public interface ContactosRepository {
	void altaContacto(Contacto contacto);
	Contacto recuperarContactoEmail(String email);
	Contacto recuperarContactoId(int idContacto);
	void eliminarContacto(int idContacto);
	List<Contacto> recuperarContactos();
}
