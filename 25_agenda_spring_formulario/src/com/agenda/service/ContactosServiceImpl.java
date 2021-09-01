package com.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.model.Contacto;
import com.agenda.repository.ContactosRepository;

@Service
public class ContactosServiceImpl implements ContactosService {
	@Autowired
	ContactosRepository cRepository;
	@Override
	public boolean nuevoContacto(Contacto contacto) {
		if(cRepository.recuperarContactoEmail(contacto.getEmail())==null) {
			cRepository.altaContacto(contacto);
			return true;
		}
		return false;
	}

	@Override
	public List<Contacto> obtenerContactos() {
		return cRepository.recuperarContactos();
	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if(cRepository.recuperarContactoId(idContacto)!=null) {
			cRepository.eliminarContacto(idContacto);
			return true;
		}
		return false;
	}

}
