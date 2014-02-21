package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-08T17:52:37.469-0300")
@StaticMetamodel(Inventory.class)
public class Inventory_ {
	public static volatile SingularAttribute<Inventory, Integer> inventoryId;
	public static volatile SingularAttribute<Inventory, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Inventory, Store> store;
	public static volatile SingularAttribute<Inventory, Film> film;
	public static volatile ListAttribute<Inventory, Rental> rentals;
}
