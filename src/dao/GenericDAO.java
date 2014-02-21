package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.GerenciadorPersistencia;

public class GenericDAO {

	public static void save(Object classe) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		// inicia transacao
		em.getTransaction().begin();
		em.persist(classe);

		em.getTransaction().commit();
		em.close();
		// System.out.println(classe.toString()+"--> salvo com sucesso!");
		// efetua a Transacao
	}

	@SuppressWarnings("unchecked")
	public static List<Object> find(String namedQuery) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		// NamedQuery
		Query query2 = em.createNamedQuery(namedQuery);

		List<Object> lista = query2.getResultList();
		em.close();
		return lista;
	}

	public static Object findById(String namedQuery, Integer id,
			String parametro) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {
			Query consulta =  em.createNamedQuery(namedQuery).setParameter(parametro, id);

			return consulta.getSingleResult();
		} finally {
			//em.close();
		}
	}

	public static void update(Object o) {
		EntityManager em2 = GerenciadorPersistencia.getEntityManager();
		try {

			em2.getTransaction().begin();
			o = em2.merge(o); // assign the merged, attached object, having the
								// new version to g
			em2.getTransaction().commit();
			// no need to flush. commit flushes automatically
		} catch (Exception e) {
			if (em2.getTransaction().isActive()) {
				em2.getTransaction().rollback();
			}

		}
		em2.close();
	}

	public static void delete(Object o) {
		EntityManager em2 = GerenciadorPersistencia.getEntityManager();
		try {

			em2.getTransaction().begin();
			em2.remove(o); // assign the merged, attached object, having the
								// new version to g
			em2.getTransaction().commit();
			// no need to flush. commit flushes automatically
		} catch (Exception e) {
			if (em2.getTransaction().isActive()) {
				em2.getTransaction().rollback();
			}

		}
		em2.close();
	}
	
	// public static Object findGrupo1(String entidade, Integer id) {
	// EntityManager em = GerenciadorPersistencia.getEntityManager();
	// try {
	// Query query2 = em.createNamedQuery(entidade + ".Grupo1")
	// .setParameter("id", id);
	// Object object = query2.getSingleResult();
	// return object;
	// } finally {
	// em.close();
	// }
	// }
	public static Object findGrupo1(String namedQuery, Integer id) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {
			Query consulta = em.createQuery(namedQuery).setParameter("id", id);

			return consulta.getSingleResult();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Object> findGrupo2(String namedQuery) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {
			Query consulta = em.createQuery(namedQuery);
			consulta.setFirstResult(0); // parametro limite Inicial
			consulta.setMaxResults(100); // parametro limite Final
			return consulta.getResultList();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Object> findGrupo3(String namedQuery) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {
			Query consulta = em.createQuery(namedQuery);
			consulta.setFirstResult(0);
			consulta.setMaxResults(1000);
			return consulta.getResultList();
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Object> findGrupo4(String namedQuery) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {

			Query consulta = em.createQuery(namedQuery);
			consulta.setFirstResult(0);
			consulta.setMaxResults(1000);
			return consulta.getResultList();

		} finally {
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Object> findGrupo(String namedQuery,int maxResult) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		try {
			Query consulta = em.createQuery(namedQuery);
			consulta.setFirstResult(0); // parametro limite Inicial
			consulta.setMaxResults(maxResult); // parametro limite Final
			return consulta.getResultList();
		} finally {
			em.close();
		}
	}

}
