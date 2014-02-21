package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-24T11:40:51.667-0300")
@StaticMetamodel(Language.class)
public class Language_ {
	public static volatile SingularAttribute<Language, Integer> languageId;
	public static volatile SingularAttribute<Language, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Language, String> name;
	public static volatile ListAttribute<Language, Film> films;
}
