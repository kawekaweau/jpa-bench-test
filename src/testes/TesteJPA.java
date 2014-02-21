package testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.GerenciadorPersistencia;
import model.Actor;
import model.Address;
import model.City;
import model.Country;
import model.Film;
import dao.GenericDAO;

public class TesteJPA {
	public static void main(String[] args) {
		try {
//			
//			List<Resultado> resultadosIns = repeteTestInsercoes(100);
//			for(Resultado r:resultadosIns){
//				System.out.println(r.toString());
//			}
//			
//			List<Resultado> resultados = repeteTestConsultas(100);
//			for(Resultado r:resultados){
//				System.out.println(r.toString());
//			}
			
			List<Resultado> resultadosExc = repeteTestExclusoes(20);
			for(Resultado r:resultadosExc){
				System.out.println(r.toString());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Long runTest(Object o) {
		Class c = o.getClass();
		Long inicio = System.currentTimeMillis();
		GenericDAO.save(c.cast(o));
		Long fim = (System.currentTimeMillis() - inicio);
		//System.out.println(o.getClass() + ": " + fim + "ms");
		return fim;
	}

	public static Long runTestList(List<Object> objects) {
		Class c = objects.get(0).getClass();
		Long inicio = System.currentTimeMillis();
		for (Object o : objects) {
			GenericDAO.save(c.cast(o));
		}
		Long fim = (System.currentTimeMillis() - inicio);
		System.out.println("Insercao " + objects.size() + " "
				+ objects.get(0).getClass() + ": " + fim + "ms");
		return fim;
	}

	public static Long runTestSearchAll(String namedQuery, String parametro,
			Integer id) {

		Long inicio = System.currentTimeMillis();
		GenericDAO.findById(namedQuery, id, parametro);
		Long fim = (System.currentTimeMillis() - inicio);

		System.out.println("Tempo Query[" + namedQuery + "]: " + fim + "ms");
		return fim;
	}

	public static void printLista(List<Object> lista) {

		//System.out.println("\n\nTodas instancias de " + lista.get(0).getClass());
		for (Object o : lista) {
			System.out.println(o.toString());
		}
	}
	//<editor-fold defaultstate="collapsed" desc="INSERCOES">
	public static Long insercaoRelacionamentoMN(Resultado r) {
		// Film f = (Film) GenericDAO.searchByIdBD("Film.findByFilmId",
		// GeradorDados.getRandomId(200), "filmId");
		//System.out.println("insercaoRelacionamentoMN(update[findById(film).add(findById(actor))]) ");
		Film f1 = (Film) GeradorDados.getRandomObjectById("film");
		Actor a = (Actor) GeradorDados.getRandomObjectById("actor");
		// System.out.println("f: "+f1.toString());
		f1.getActors().add(a);
		// System.out.println("a: "+a.toString());
		r.setDescricao("insercaoRelacionamentoMN(update[findById(film).add(findById(actor))]) ");
		r.setQuery(" ");
		Long inicio = System.currentTimeMillis();
		GenericDAO.update(f1);
		Long fim = (System.currentTimeMillis() - inicio);
		//System.out.println(f1.getClass() + ": " + fim + "ms");
		r.addTempo(fim);
		return fim;
		// System.out.println("f: "+f1.toString());
	}
	public static Long insercaoSimples(Resultado r) {
		//System.out.println("insercaoSimples(Actor('nome','sobreNome')) ");
		Actor a = (Actor) GeradorDados.geraActor();
		r.setDescricao("insercaoSimples(Actor('nome','sobreNome'))");
		r.setQuery(" ");
		Long tempo = runTest(a);
		r.addTempo(tempo);
		return tempo;
	}
	public static Long insercaoAninhada(Resultado r) {
		//System.out.println("insercaoAninhada(Address('rua','dist','fone',City('cidade',Country('pais')))) ");
		Country c = new Country("Brazil" + System.currentTimeMillis());
		City ct = new City("Dourados" + System.currentTimeMillis(), c);
		Address ad = new Address("rua Cuiaba" + System.currentTimeMillis(),
				"MS", "(67)", ct);
		r.setDescricao("insercaoAninhada(Address('rua','dist','fone',City('cidade',Country('pais')))) ");
		r.setQuery(" ");
		Long tempo = runTest(ad);
		r.addTempo(tempo);
		return tempo;
		// System.out.println(ad.toString());
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="CONSULTA">
	public static Long buscaEmProfundidade(Resultado r) {
		//System.out.println("buscaEmProfundidade()");
		// Metrica 4: Busca em profundidade no modelo
		// "select desktop from Desktop desktop inner join
		// desktop.secretario as secretario inner join
		// secretario.departamento as departamento inner join
		// departamento.divisao as divisao where divisao.chefe.id = '1'"
		String query = "SELECT p FROM Payment p INNER JOIN "
				+ "p.rental as r INNER JOIN r.inventory  as i "
				+ "INNER JOIN i.store as s "
				+ " WHERE s.storeId = 1";
		r.setDescricao("buscaEmProfundidade");
		r.setQuery(query);
//		String query = "SELECT p FROM Payment p INNER JOIN "
//				+ "p.rental as r INNER JOIN r.inventory  as i "
//				+ "INNER JOIN i.filmId as f "
//				+ "INNER JOIN f.actorId as a "
//				+ " WHERE a.actorId = 1";
		

		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo2(query);
		Long fim = (System.currentTimeMillis() - inicio);
		r.addTempo(fim);
		//System.out.println("Tempo Query[" + query + "]: " + fim + "ms");
		return fim;

		// System.out.println(ad.toString());
	}
	public static Long consulta_relacionamento_mn(Resultado r) {
		// Metrica 3: Recuperacao de entidades num relacionamento M-N.
		// "select engenheiro from Engenheiro engenheiro inner join
		// engenheiro.professionalUnions as assoc where assoc.nome = 'CUT' and
		// engenheiro.id < 99";

		// String query = "SELECT f FROM Film f "
		// + "INNER JOIN f.actorId as a"
		// + " where a.firstName = 'John%' and f.filmId < 99";

		
		String query = "select r " + "from Rental r "
				+ "inner join r.customer as c"
				+ " where c.firstName = 'john%' and r.rentalId < 99";
		r.setDescricao("consulta em relacionamento M-N");
		r.setQuery(query);
		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo2(query);
		Long fim = (System.currentTimeMillis() - inicio);
		r.addTempo(fim);
		//System.out.println("Tempo Query[" + query + "]: " + fim + "ms");
		return fim;
	}
	public static Long consultaGrupo1(Resultado r) {
		// Selecao Grupo 1 (CPU - Baixo, Memoria - Baixo)
		// Selecao de uma tupla campo indexada
		// SELECT d FROM Departamento d WHERE d.id =:c�digo�
		r.setDescricao("consulta Grupo1 Selecao de uma tupla campo indexada");
		Integer id = GeradorDados.getRandomId(200);
		String query = String.format("SELECT c FROM Customer c WHERE c.customerId = %d", id);
		r.setQuery(query);
		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo2(query);
		Long fim = (System.currentTimeMillis() - inicio);
		r.addTempo(fim);
		return fim;
		// consultaGrupo1("actor",15);
		// consultaGrupo1("film",15);
		// consultaGrupo1("rental",15);
		// consultaGrupo1("payment",15);
	}
	public static Long consultaGrupo2(Resultado r) {
		// Selecao Grupo 2 (CPU - Baixo, Disco - Alto)
		// Selecao de 100 tuplas em 1000 nao indexado
		// FROM Departamento d WHERE d.desc LIKE �Desc%� AND d.id > 5000�
//		System.out
//				.println("consulta Grupo2 Selecao de 100 tuplas em 10000 nao indexado()");
		//String query = "FROM Film f WHERE f.title LIKE 'on%' AND f.filmId > 500";
		r.setDescricao("consulta Grupo2 Selecao de 100 tuplas em 10000 nao indexado");
		Integer id = GeradorDados.getRandomId(500);
		String query = "FROM Film f WHERE f.title LIKE 'on%' AND f.filmId > "+ id;
		r.setQuery(query);
		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo2(query);
		Long fim = (System.currentTimeMillis() - inicio);		
		r.addTempo(fim);
		//System.out.println("Tempo Query[" + query + "]: " + fim + "ms");
		return fim;
	}
	public static Long consultaGrupo3(Resultado r) {
		// Selecao Grupo 3 (CPU - Alto, Disco - Baixo)
		// Selecionar 1.000 tuplas de 10.000 utilizando �ndice com rela��o a
		// outra tabela com 10.000
		// createQuery("select d from Dependente d left join fetch d.sexo left join fetch d.sexo where d.sexo.idSexo = 2"
//		System.out
//				.println("consulta Grupo3 Selecionar 1.000 tuplas de 10.000 utilizando indice com relacao a outra tabela()");
//		String query = "select p from Payment p " + "left join fetch p.rental "
//				+ "left join fetch p.rental where p.rental.rentalId = 2";
		r.setDescricao("consulta Grupo3 Selecionar 1.000 tuplas de 10.000 utilizando indice com relacao a outra tabela");
		Integer id = GeradorDados.getRandomId(500);
		String query = String.format("select p from Payment p " + "left join fetch p.rental "
				+"left join fetch p.rental where p.rental.rentalId = %d", id);
		r.setQuery(query);
		
		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo3(query);
		Long fim = (System.currentTimeMillis() - inicio);
		r.addTempo(fim);
		//System.out.println("Tempo Query[" + query + "]: " + fim + "ms");
		return fim;
	}
	public static Long consultaGrupo4(Resultado r) {
		// Selecao Grupo 4 (CPU - Alto, Disco - Alto)
		// Grupo 4 - Selecionar 100 registros com funcao agregada 10.000 tuplas
		// "select count(d) from Dependente d where d.empregado.idEmpregado = 1 and idDependente <= 100"
		//System.out.println("consulta Grupo4 ");
//		String query = "select count(p) from Payment p "
//				+ "where p.customer.customerId = 1 and p.paymentId <= 100";
		r.setDescricao("consulta Grupo3 Selecionar 1.000 tuplas de 10.000 utilizando indice com relacao a outra tabela");
		Integer id = GeradorDados.getRandomId(100);
		String query = String.format("select count(p) from Payment p "
				+ "where p.customer.customerId = 1 and p.paymentId <= %d", id);
		r.setQuery(query);
		Long inicio = System.currentTimeMillis();
		GenericDAO.findGrupo4(query);
		Long fim = (System.currentTimeMillis() - inicio);
		//System.out.println("Tempo Query[" + query + "]: " + fim + "ms");
		r.addTempo(fim);
		return fim;
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="EXCLUSOES">
	public static Long exclusaoRelacionamentoMN(Resultado r) {
		
		Film f1 = (Film) GeradorDados.getRandomObjectById("film");
		while(f1.getActors().isEmpty()){
			f1 = (Film) GeradorDados.getRandomObjectById("film");
		}
		f1.getActors().remove(0);
		r.setDescricao("exclusaoRelacionamentoMN(update[findById(film).getActors().remove() ");
		r.setQuery("UPDATE");
		Long inicio = System.currentTimeMillis();
		GenericDAO.update(f1);
		Long fim = (System.currentTimeMillis() - inicio);
		//System.out.println(f1.getClass() + ": " + fim + "ms");
		r.addTempo(fim);
		return fim;
		// System.out.println("f: "+f1.toString());
	}
	public static Long exclusaoSimples(Resultado r) {
		
		Country c = (Country) GenericDAO.findById("Country.findByCountryId", 200, "countryId");
		
		r.setDescricao("exclusaoSimples(Country)");
		r.setQuery("em.remove");
		Long inicio = System.currentTimeMillis();
		GenericDAO.delete(c);
		Long fim = (System.currentTimeMillis() - inicio);
		//System.out.println(f1.getClass() + ": " + fim + "ms");
		r.addTempo(fim);
		return fim;
		
	}
	public static Long exclusaoAninhada(Resultado r) {
		EntityManager em = GerenciadorPersistencia.getEntityManager();
		Actor a = new Actor();
		Query consulta = em.createQuery(
				"SELECT a FROM Actor a WHERE a.actorId > :id")
				.setParameter("id", GeradorDados.getRandomId(200));
		consulta.setFirstResult(0);
		consulta.setMaxResults(1);
		a = (Actor) consulta.getSingleResult();
		try {
			while (a.getFilms().isEmpty()) {
				consulta = em.createQuery(
						"SELECT a FROM Actor a WHERE a.actorId > :id")
						.setParameter("id", GeradorDados.getRandomId(200));
				consulta.setFirstResult(0);
				consulta.setMaxResults(1);
				a = (Actor) consulta.getSingleResult();
			}
		} finally {
			em.close();
		}
		r.setDescricao("exclusaoAninhada(Actor[cascade.all])");
		r.setQuery("em.delete()");
		Long inicio = System.currentTimeMillis();
		GenericDAO.delete(a);
		Long fim = (System.currentTimeMillis() - inicio);
		// System.out.println(f1.getClass() + ": " + fim + "ms");
		r.addTempo(fim);
		return fim;
		// System.out.println("f: "+f1.toString());
	}
	//</editor-fold>
	
	public static List <Resultado> repeteTestInsercoes(int times) {
		List <Resultado> resultadosInsercoes = new ArrayList();
		Resultado c1 = new Resultado(0,"insercaoSimples(Actor('nome','sobreNome')) ");
		Resultado c2 = new Resultado(1,"insercaoAninhada(Address('rua','dist','fone',City('cidade',Country('pais')))) ");
		Resultado c3 = new Resultado(2,"insercaoRelacionamentoMN(update[findById(film).add(findById(actor))]) ");


		resultadosInsercoes.add(c1);
		resultadosInsercoes.add(c2);
		resultadosInsercoes.add(c3);


		for (int i = 0; i < times; i++) {
			insercaoSimples(c1);
			insercaoAninhada(c2);
			insercaoRelacionamentoMN(c3);
		}
		return resultadosInsercoes;
	}
	public static List <Resultado>  repeteTestConsultas(int times) {
		
		List <Resultado> resultadosConsultas = new ArrayList();
		Resultado c1 = new Resultado(0,"buscaEmProfundidade");
		Resultado c2 = new Resultado(1,"consulta_relacionamento_mn");
		Resultado c3 = new Resultado(2,"consultaGrupo1");
		Resultado c4 = new Resultado(3,"consultaGrupo2");
		Resultado c5 = new Resultado(4,"consultaGrupo3");
		Resultado c6 = new Resultado(5,"consultaGrupo4");

		resultadosConsultas.add(c1);
		resultadosConsultas.add(c2);
		resultadosConsultas.add(c3);
		resultadosConsultas.add(c4);
		resultadosConsultas.add(c5);
		resultadosConsultas.add(c6);

		for (int i = 0; i < times; i++) {
			buscaEmProfundidade(c1);
			consulta_relacionamento_mn(c2);
			consultaGrupo1(c3);
			consultaGrupo2(c4);
			consultaGrupo3(c5);
			consultaGrupo4(c6);
		}
		return resultadosConsultas;
	}

	public static List <Resultado>  repeteTestExclusoes(int times) {
		
		List <Resultado> resultados = new ArrayList();
		Resultado c1 = new Resultado(0,"exclusaoSimples");
		Resultado c2 = new Resultado(1,"exclusao_relacionamento_mn");
		Resultado c3 = new Resultado(2,"exclusaoAninhada");
	
		resultados.add(c1);
		resultados.add(c2);
		resultados.add(c3);
		
		for (int i = 0; i < times; i++) {
			exclusaoSimples(c1);
			exclusaoRelacionamentoMN(c2);
			exclusaoAninhada(c3);
		}
		return resultados;
	}
	
}





/*
 * runTestSearchAll("Actor.findAll"); //200 registros
 * runTestSearchAll("Customer.findAll"); //599 registros
 * runTestSearchAll("Film.findAll"); //1000 registros (Actor,Category,Language)
 * runTestSearchAll("Inventory.findAll"); //4581 registros (Film, Rentals)
 * runTestSearchAll("Rental.findAll"); //16044 registros
 * runTestSearchAll("Payment.findAll"); //145996 registros
 * 
 * }//
 * 
 * public static void repeteTestInsercoes(int times) {
		Long iS, iA, iR;
		iS = insercaoSimples();
		iA = insercaoAninhada();
		iR = insercaoRelacionamentoMN();
		times--;
		iS = insercaoSimples();
		iA = insercaoAninhada();
		iR = insercaoRelacionamentoMN();
		times--;
		for (int i = 0; i < times; i++) {
			iS = (iS + insercaoSimples()) / 2;
			iA = (iA + insercaoAninhada()) / 2;
			iR = (iR + insercaoRelacionamentoMN()) / 2;
		}
		System.out.println("medias/n insercaoSimples(): " + iS
				+ ", insercaoAninhada(): " + iA
				+ ", insercaoRelacionamentoMN(): " + iR);
	}
 */
// printLista(GenericDAO.searchBD("Film.findAll"));
