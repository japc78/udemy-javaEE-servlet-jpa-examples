package com.agenda.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.agenda.model.Contacto;

@Repository
public class ContactosRepositoryImpl implements ContactosRepository {
	@Autowired
	JdbcTemplate template;
	
	@Override
	public void altaContacto(Contacto contacto) {
		String sql="insert into contactos (nombre,email,telefono) values(?,?,?)";
		template.update(sql, contacto.getNombre(),contacto.getEmail(),contacto.getTelefono());
	}

	@Override
	public Contacto recuperarContactoEmail(String email) {
		String sql="Select * from contactos where email=?";
		List<Contacto> contactos= template.query(sql, 
							  (rs,f)->new Contacto(rs.getInt("idContacto"),
												rs.getString("nombre"),
												rs.getString("email"),
												rs.getInt("telefono")),
							  email);
		return contactos.size()>0?contactos.get(0):null;
	}

	@Override
	public Contacto recuperarContactoId(int idContacto) {
		String sql="Select * from contactos where idContacto=?";
		List<Contacto> contactos= template.query(sql, 
							  (rs,f)->new Contacto(rs.getInt("idContacto"),
												rs.getString("nombre"),
												rs.getString("email"),
												rs.getInt("telefono")),
							  idContacto);
		return contactos.size()>0?contactos.get(0):null;
	}

	@Override
	public void eliminarContacto(int idContacto) {
		String sql="delete from contactos where idContacto=?";
		template.update(sql,idContacto);
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String sql="select * from contactos";
		return template.query(sql, (rs,f)->new Contacto(rs.getInt("idContacto"),
				rs.getString("nombre"),
				rs.getString("email"),
				rs.getInt("telefono")));
	}

}
