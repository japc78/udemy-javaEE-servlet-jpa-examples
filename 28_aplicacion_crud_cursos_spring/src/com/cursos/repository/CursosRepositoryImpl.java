package com.cursos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.model.Curso;
@Repository
public class CursosRepositoryImpl implements CursosRepository {
	@PersistenceContext(unitName = "cursosPU")
	EntityManager em;

	@Transactional
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);
	}

	@Override
	public Curso buscarCursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso);
	}
	@Transactional
	@Override
	public void eliminarCurso(Curso curso) {
		em.remove(buscarCursoPorId(curso.getIdCurso()));
	}
	@Transactional
	@Override
	public void actualizarCurso(Curso curso) {
		em.merge(curso);

	}

	@Override
	public List<Curso> cursosDuracion(int duracion) {
		//String jpql="select c from Curso c where c.duracion<=?1";
		TypedQuery<Curso> query=em.createNamedQuery("Curso.findByDuracion",Curso.class);
		query.setParameter(1, duracion);
		return query.getResultList();
	}

	@Override
	public void eliminarCursosNombre(String dato) {
		EntityTransaction tx=em.getTransaction();
		String jpql="delete from Curso c where c.denominacion like ?1";
		Query query=em.createQuery(jpql);
		query.setParameter(1, "%"+dato+"%");
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
	}

	@Override
	public void reducirPrecioCursos(int duracion, int porcentaje) {
		EntityTransaction tx=em.getTransaction();
		String jpql="update Curso c set c.precio=c.precio*((100-?1)/100) ";
		jpql+="where c.duracion>?2";
		Query query=em.createQuery(jpql);
		query.setParameter(1, porcentaje);
		query.setParameter(2, duracion);
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
	}

}
