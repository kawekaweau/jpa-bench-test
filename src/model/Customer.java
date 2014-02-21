package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByActive", query = "SELECT c FROM Customer c WHERE c.active = :active"),
    @NamedQuery(name = "Customer.findByCreateDate", query = "SELECT c FROM Customer c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "Customer.findByLastUpdate", query = "SELECT c FROM Customer c WHERE c.lastUpdate = :lastUpdate")})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Integer customerId;

	private Integer active;

	private Boolean activebool;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="last_update")
	private Timestamp lastUpdate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Store store;
//@Column(name="store_id")
	//private Integer storeId;

	//bi-directional many-to-one association to Address
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

//	//bi-directional many-to-one association to Payment
//	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
//	private List<Payment> payments;
//
//	//bi-directional many-to-one association to Rental
//	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
//	private List<Rental> rentals;

	public Customer() {
	}
	
	

	public Customer(Date createDate, String firstName, String lastName,
		Timestamp lastUpdate, Store store, Address address) {
	super();
	this.createDate = new Timestamp(System.currentTimeMillis());
	this.firstName = firstName;
	this.lastName = lastName;
	this.lastUpdate = new Timestamp(System.currentTimeMillis());
	this.store = store;
	this.address = address;
}



	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Boolean getActivebool() {
		return this.activebool;
	}

	public void setActivebool(Boolean activebool) {
		this.activebool = activebool;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public List<Payment> getPayments() {
//		return this.payments;
//	}
//
//	public void setPayments(List<Payment> payments) {
//		this.payments = payments;
//	}
//
//	public Payment addPayment(Payment payment) {
//		getPayments().add(payment);
//		payment.setCustomer(this);
//
//		return payment;
//	}
//
//	public Payment removePayment(Payment payment) {
//		getPayments().remove(payment);
//		payment.setCustomer(null);
//
//		return payment;
//	}
//
//	public List<Rental> getRentals() {
//		return this.rentals;
//	}
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}
//
//	public Rental addRental(Rental rental) {
//		getRentals().add(rental);
//		rental.setCustomer(this);
//
//		return rental;
//	}
//
//	public Rental removeRental(Rental rental) {
//		getRentals().remove(rental);
//		rental.setCustomer(null);
//
//		return rental;
//	}

	@Override
	public String toString() {
		String pagamentos ="";
//		for(Payment p:payments){
//			pagamentos+=", R$"+p.getAmount()+":"+p.getPaymentDate()+".\n";
//		}
		return "#Cliente[" + customerId + "]: "
				+ firstName + " " + lastName + ", " + store
				+ "\npagamentos:" + pagamentos;
	}
	
}