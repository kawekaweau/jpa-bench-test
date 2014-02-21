package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-24T11:40:51.670-0300")
@StaticMetamodel(Staff.class)
public class Staff_ {
	public static volatile SingularAttribute<Staff, Integer> staffId;
	public static volatile SingularAttribute<Staff, Boolean> active;
	public static volatile SingularAttribute<Staff, String> email;
	public static volatile SingularAttribute<Staff, String> firstName;
	public static volatile SingularAttribute<Staff, String> lastName;
	public static volatile SingularAttribute<Staff, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Staff, String> password;
	public static volatile SingularAttribute<Staff, byte[]> picture;
	public static volatile SingularAttribute<Staff, Integer> storeId;
	public static volatile SingularAttribute<Staff, String> username;
	public static volatile ListAttribute<Staff, Payment> payments;
	public static volatile ListAttribute<Staff, Rental> rentals;
	public static volatile SingularAttribute<Staff, Address> address;
	public static volatile ListAttribute<Staff, Store> stores;
}
