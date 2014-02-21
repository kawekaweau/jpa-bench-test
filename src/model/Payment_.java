package model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-24T11:40:51.668-0300")
@StaticMetamodel(Payment.class)
public class Payment_ {
	public static volatile SingularAttribute<Payment, Integer> paymentId;
	public static volatile SingularAttribute<Payment, BigDecimal> amount;
	public static volatile SingularAttribute<Payment, Timestamp> paymentDate;
	public static volatile SingularAttribute<Payment, Customer> customer;
	public static volatile SingularAttribute<Payment, Rental> rental;
	public static volatile SingularAttribute<Payment, Staff> staff;
}
