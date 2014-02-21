package model;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-08T17:52:37.317-0300")
@StaticMetamodel(Customer.class)
public class Customer_ {
	public static volatile SingularAttribute<Customer, Integer> customerId;
	public static volatile SingularAttribute<Customer, Integer> active;
	public static volatile SingularAttribute<Customer, Boolean> activebool;
	public static volatile SingularAttribute<Customer, Date> createDate;
	public static volatile SingularAttribute<Customer, String> email;
	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Customer, Store> store;
	public static volatile SingularAttribute<Customer, Address> address;
}
