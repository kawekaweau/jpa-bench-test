package testes;

//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Actor;
import dao.GenericDAO;

public class GeradorDados {
		public static Actor geraActor(){
			Actor aux = (Actor) getRandomObjectById("actor");
			Actor aux2 = (Actor) getRandomObjectById("actor");
			Actor a = new Actor(aux.getFirstName(),aux2.getLastName());
			return a;
		}
		
		public static List <Object>  getListActor(int size){
			
			List <Object> list = new ArrayList<Object>();
			for(int i=0;i<size;i++){
				Object o = geraActor();
				list.add(o);
			}
			return list;
		}
		
public static Object getRandomObjectById(String obj){
			
			String s = obj.substring(0, 1).toUpperCase() + obj.substring(1).toLowerCase();
			String namedQuery = s+".findBy"+s+"Id";
			Object o =null;
			while(o==null){
				Integer id = GeradorDados.getRandomId(200);
				id++;
				o = GenericDAO.findById(namedQuery, id, obj.toLowerCase()+"Id");
			}
			return o;
		}
		public static Integer getRandomId(int max){
			Random id = new Random();
			/*
			runTestSearchAll("Actor.findAll");     //200 registros
			runTestSearchAll("Customer.findAll");  //599 registros
			runTestSearchAll("Film.findAll");      //1000 registros (Actor,Category,Language)
			runTestSearchAll("Inventory.findAll"); //4581 registros (Film, Rentals)
			runTestSearchAll("Rental.findAll");    //16044 registros				
			runTestSearchAll("Payment.findAll");   //145996 registros
			
		}//*/
			//id.nextInt();
			return id.nextInt(max);
		}
		
		
}
