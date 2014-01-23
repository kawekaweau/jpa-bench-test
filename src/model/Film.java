package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id")
	private Integer filmId;

	private String description;

	private Object fulltext;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private Integer length;

	private String rating;

	@Column(name="release_year")
	private Object releaseYear;

	@Column(name="rental_duration")
	private Integer rentalDuration;

	@Column(name="rental_rate")
	private BigDecimal rentalRate;

	@Column(name="replacement_cost")
	private BigDecimal replacementCost;

	@Column(name="special_features")
	private Array specialFeatures;

	private String title;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="film")
	private List<Inventory> inventories;

	public Film() {
	}

	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getFulltext() {
		return this.fulltext;
	}

	public void setFulltext(Object fulltext) {
		this.fulltext = fulltext;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Object getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Object releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Array getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(Array specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setFilm(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setFilm(null);

		return inventory;
	}

}