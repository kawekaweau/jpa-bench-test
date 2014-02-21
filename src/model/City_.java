package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-03T12:51:58.216-0300")
@StaticMetamodel(City.class)
public class City_ {
	public static volatile SingularAttribute<City, Integer> cityId;
	public static volatile SingularAttribute<City, String> city;
	public static volatile SingularAttribute<City, Timestamp> lastUpdate;
	public static volatile SingularAttribute<City, Country> country;
}
