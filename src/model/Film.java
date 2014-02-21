package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
		@NamedQuery(name = "Film.findByFilmId", query = "SELECT f FROM Film f WHERE f.filmId = :filmId"),
		@NamedQuery(name = "film.Grupo1", query = "SELECT f FROM Film f WHERE f.filmId = :id"),
		@NamedQuery(name = "Film.findByTitle", query = "SELECT f FROM Film f WHERE f.title = :title"),
		@NamedQuery(name = "Film.findByRentalDuration", query = "SELECT f FROM Film f WHERE f.rentalDuration = :rentalDuration"),
		@NamedQuery(name = "Film.findByRentalRate", query = "SELECT f FROM Film f WHERE f.rentalRate = :rentalRate"),
		@NamedQuery(name = "Film.findByLength", query = "SELECT f FROM Film f WHERE f.length = :length"),
		@NamedQuery(name = "Film.findByReplacementCost", query = "SELECT f FROM Film f WHERE f.replacementCost = :replacementCost")})
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;

	private String description;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	private Integer length;

	@Column(name = "rental_duration")
	private Integer rentalDuration;

	@Column(name = "rental_rate")
	private BigDecimal rentalRate;

	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;

	private String title;

	// bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	// bi-directional many-to-one association to FilmActor
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "film_actor", schema = "PUBLIC", joinColumns = @JoinColumn(name = "FILM_ID"), inverseJoinColumns = @JoinColumn(name = "ACTOR_ID"))
	private List<Actor> actors;

	// bi-directional many-to-one association to FilmCategory
	@ManyToMany//(fetch = FetchType.LAZY)
	@JoinTable(name = "FILM_CATEGORY", schema = "PUBLIC", joinColumns = @JoinColumn(name = "FILM_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private List<Category> categories;

	// bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy = "film")
	private List<Inventory> inventories;

	// <editor-fold defaultstate="collapsed" desc="COMENTADOS">

	// @Column(name="special_features")
	// private String specialFeatures;

	// @Column(name="release_year")
	// @Temporal(TemporalType.DATE)
	// private Date releaseYear;

	// private String rating;

	// private String fulltext;

	// public String getFulltext() {
	// return this.fulltext;
	// }
	//
	// public void setFulltext(String fulltext) {
	// this.fulltext = fulltext;
	// }
	// public String getRating() {
	// return this.rating;
	// }
	//
	// public void setRating(String rating) {
	// this.rating = rating;
	// }
	// public String getSpecialFeatures() {
	// return this.specialFeatures;
	// }
	//
	// public void setSpecialFeatures(String specialFeatures) {
	// this.specialFeatures = specialFeatures;
	// }
	// </editor-fold

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

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	@Override
	public String toString() {
		String actor = "";
		for (Actor a : actors) {
			actor += ", " + a.getFirstName();
		}

		actor.replaceFirst(",", "");
		return "#Film " + filmId + ": " + title + "-" + language.getName()
				+ "\n actors:" + actor.substring(1) + "\n"
		// + ", categories=" + categories + ", inventories=" + inventories

		;
	}

}