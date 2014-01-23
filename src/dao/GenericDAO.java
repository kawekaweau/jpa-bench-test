package dao;

import javax.persistence.EntityManager;

import persistencia.GerenciadorPersistencia;


public class GenericDAO {
	//NamedQuery
    //Query query2 = em.createNamedQuery("findAllCliente");
    
    //NamedQuery com parametros
    //Query query2 = em.createNamedQuery("findPessoaById");
    //query2.setParameter("id",new Long(196608));
     /*       
     System.out.println("\n\nTodas instancias de Clientes");
     
     List<Cliente> pessoas = query2.getResultList();
    
    for(Cliente c : pessoas){
        System.out.println(c.toString());
    }
    //*/
	public static void gravaBD(Object classe){
        EntityManager em = GerenciadorPersistencia.getEntityManager();
        //inicia transação
        em.getTransaction().begin();
        em.persist(classe);
        System.out.println(classe.toString()+"--> salvo com sucesso!");
        //efetua a Transação
        em.getTransaction().commit();
	} 
}
