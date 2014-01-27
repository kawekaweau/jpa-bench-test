package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.GerenciadorPersistencia;


public class GenericDAO {
	/*static EntityManager em ;
	
	
	
	public static EntityManager getEm() {
		return em;
	}
	public static void setEm() {
		Long inicio = System.currentTimeMillis();
		System.out.println("{");
		GenericDAO.em = GerenciadorPersistencia.getEntityManager();
		Long fim = (System.currentTimeMillis() - inicio);
		System.out.println("\nTempo GenericDAO set EntityManager: " + fim + "ms }\n\n");
	}*/
	public static void gravaBD(Object classe){
       EntityManager em = GerenciadorPersistencia.getEntityManager();
        //inicia transa��o
        em.getTransaction().begin();
        em.persist(classe);
        //System.out.println(classe.toString()+"--> salvo com sucesso!");
        //efetua a Transa��o
        em.getTransaction().commit();
	} 
	@SuppressWarnings("unchecked")
	public static List<Object> searchBD(String namedQuery){
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		//NamedQuery
	    Query query2 = em.createNamedQuery(namedQuery);
	    
	    List<Object> lista = query2.getResultList();	    
	    return lista;
	}
}
