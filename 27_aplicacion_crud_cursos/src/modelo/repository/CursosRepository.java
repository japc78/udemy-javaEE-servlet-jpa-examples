package modelo.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Curso;

public class CursosRepository {
	EntityManager em;
	public CursosRepository() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
		em=factory.createEntityManager();
	}
	
	public void altaCurso(Curso curso) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(curso);
		tx.commit();
	}
	
	public Curso buscarCursoPorId(int idCurso) {
		return em.find(Curso.class, idCurso);
	}
	
	public void actualizarCurso(Curso curso) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(curso);
		tx.commit();
	}
	public void eliminarCurso(Curso curso) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(curso);
		tx.commit();
	}
	
	
}
