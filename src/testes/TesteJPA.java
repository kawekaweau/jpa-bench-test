package testes;



import model.Actor;

import dao.GenericDAO;

public class TesteJPA {
	public static void main(String[] args){
        try{
        	/*Timestamp time = new Timestamp(0);  
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        	String formatedDate = format.format(time.getTime());*/
        	 
        	Actor a = new Actor("John","Snow");
        	
        	GenericDAO.gravaBD(a);
        	
        	
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
    
}
