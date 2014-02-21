package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-28T08:43:53.158-0300")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Integer> addressId;
	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, String> address2;
	public static volatile SingularAttribute<Address, String> district;
	public static volatile SingularAttribute<Address, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Address, String> phone;
	public static volatile SingularAttribute<Address, String> postalCode;
	public static volatile SingularAttribute<Address, City> city;
}
