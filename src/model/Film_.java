package model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-03T13:39:29.881-0300")
@StaticMetamodel(Film.class)
public class Film_ {
	public static volatile SingularAttribute<Film, Integer> filmId;
	public static volatile SingularAttribute<Film, String> description;
	public static volatile SingularAttribute<Film, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Film, Integer> length;
	public static volatile SingularAttribute<Film, Integer> rentalDuration;
	public static volatile SingularAttribute<Film, BigDecimal> rentalRate;
	public static volatile SingularAttribute<Film, BigDecimal> replacementCost;
	public static volatile SingularAttribute<Film, String> title;
	public static volatile SingularAttribute<Film, Language> language;
	public static volatile ListAttribute<Film, Actor> actors;
	public static volatile ListAttribute<Film, Category> categories;
	public static volatile ListAttribute<Film, Inventory> inventories;
}
