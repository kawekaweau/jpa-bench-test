package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-28T08:09:12.991-0300")
@StaticMetamodel(Category.class)
public class Category_ {
	public static volatile SingularAttribute<Category, Integer> categoryId;
	public static volatile SingularAttribute<Category, Timestamp> lastUpdate;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, Film> films;
}
