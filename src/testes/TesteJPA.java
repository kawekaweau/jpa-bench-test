package testes;

import java.sql.Timestamp;
import java.util.List;

import model.Actor;
import dao.GenericDAO;

public class TesteJPA {
	public static void main(String[] args) {
		try {
			/*
			 * Timestamp time = new Timestamp(0); SimpleDateFormat format = new
			 * SimpleDateFormat("yyyy-MM-dd"); String formatedDate =
			 * format.format(time.getTime());
			 */
			//GenericDAO g = new GenericDAO();
			
		//			
			
			Actor a = new Actor("John"
					+ new Timestamp(System.currentTimeMillis()), "Snow" + " "
					+ new Timestamp(System.currentTimeMillis()));
			Actor b = new Actor("Aria"
					+ new Timestamp(System.currentTimeMillis()), "Stark" + " "
					+ new Timestamp(System.currentTimeMillis()));
			Actor c = new Actor("Tyron"
					+ new Timestamp(System.currentTimeMillis()), "Lannister"
					+ " " + new Timestamp(System.currentTimeMillis()));
			
			runTest(a);
			/*
			for(int i=0;i<13;i++){
				System.out.println("i["+i+"]: ");
				runTestSearchAll("Actor.findAll");//200 registros
				runTestSearchAll("Film.findAll");//1000 registros (Actor,Category,Language)
				runTestSearchAll("Inventory.findAll");//4581 registros (Film, Rentals)
				runTestSearchAll("Rental.findAll");//16044 registros
				runTestSearchAll("Customer.findAll");//599 registros
				runTestSearchAll("Payment.findAll");//145996 registros
				
			}//*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void runTest(Object o) {

		Long inicio = System.currentTimeMillis();
		GenericDAO.gravaBD((Actor) o);
		Long fim = (System.currentTimeMillis() - inicio);
		System.out.println("Tempo Query[" + o.getClass() + "]: " + fim + "ms");
	}

	public static void runTestSearchAll(String namedQuery) {

		Long inicio = System.currentTimeMillis();
		
		GenericDAO.searchBD(namedQuery);
		Long fim = (System.currentTimeMillis() - inicio);
		
		System.out.println("Tempo Query[" + namedQuery + "]: " + fim + "ms");
		

	}

	public static void printLista(List<Object> lista) {

		System.out.println("\n\nTodas instancias de " + lista.getClass());
		for (Object o : lista) {
			System.out.println(o.toString());
		}
	}
}
