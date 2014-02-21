package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-24T11:40:51.672-0300")
@StaticMetamodel(Store.class)
public class Store_ {
	public static volatile SingularAttribute<Store, Integer> storeId;
	public static volatile SingularAttribute<Store, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Store, Address> address;
	public static volatile SingularAttribute<Store, Staff> staff;
}
