package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorPersistencia {
	private static EntityManagerFactory emf;
	static{
		emf=Persistence.createEntityManagerFactory("UnidadePersistencia");
	}
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}