package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-02-03T13:04:36.143-0300")
@StaticMetamodel(Country.class)
public class Country_ {
	public static volatile SingularAttribute<Country, Integer> countryId;
	public static volatile SingularAttribute<Country, String> country;
	public static volatile SingularAttribute<Country, Timestamp> lastUpdate;
}
