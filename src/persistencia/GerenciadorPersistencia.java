package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorPersistencia {
	private static EntityManagerFactory emf;
	static{
		Long inicio = System.currentTimeMillis();
		emf=Persistence.createEntityManagerFactory("UnidadePersistencia");
		Long fim = (System.currentTimeMillis() - inicio);
		System.out.println("\nTempo Criação EntityManagerFactory: " + fim + "ms");
	}
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
