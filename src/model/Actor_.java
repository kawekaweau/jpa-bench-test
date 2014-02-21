package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-27T16:57:00.395-0300")
@StaticMetamodel(Actor.class)
public class Actor_ {
	public static volatile SingularAttribute<Actor, Integer> actorId;
	public static volatile SingularAttribute<Actor, String> firstName;
	public static volatile SingularAttribute<Actor, String> lastName;
	public static volatile SingularAttribute<Actor, Timestamp> lastUpdate;
	public static volatile ListAttribute<Actor, Film> films;
}
