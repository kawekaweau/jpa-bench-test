package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-24T11:40:51.669-0300")
@StaticMetamodel(Rental.class)
public class Rental_ {
	public static volatile SingularAttribute<Rental, Integer> rentalId;
	public static volatile SingularAttribute<Rental, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Rental, Timestamp> rentalDate;
	public static volatile SingularAttribute<Rental, Timestamp> returnDate;
	public static volatile ListAttribute<Rental, Payment> payments;
	public static volatile SingularAttribute<Rental, Customer> customer;
	public static volatile SingularAttribute<Rental, Inventory> inventory;
	public static volatile SingularAttribute<Rental, Staff> staff;
}
