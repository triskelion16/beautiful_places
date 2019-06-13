package pl.beautifulplaces.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Marcin
 *
 * Hibernate - tabela: places
 */
@Entity
@Table(name="places")
public class Place {

	// Hibernate - kolumna: id | klucz główny | automatyczna inkrementacja
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Hibernate - kolumna: name | pozycja wymagana
	@NotEmpty(message = "Pole nie może być puste!")
	private String name;
	
	// Hibernate - kolumna: description | do 500 znaków
	@Column(length=500)
	@NotEmpty(message = "Pole nie może być puste!")
	@Size(max=500, message = "Maksymalna ilość znaków to 500!")
	private String description;
	
	// Hibernate - kolumna date | data i czas utworzenia obiektu
	private Date date = new Date();
	
	// Hibernate - kolumna: continent | relacja wiele do jednego z tabelą: continents
	@ManyToOne
	private Continent continent;
	
	// Hibernate - kolumna: jpg | zdjęcie zapisane jako ciąg znaków
	@Column(columnDefinition = "mediumtext")
	private String jpg;
	
	// Pole jpgPath nie jest zapisywane do bazy danych 
	@Transient
	private String jpgPath;
	
	// Hibernate - kolumna: details | do 500 znaków
	@Column(length=5000)
	@NotEmpty(message = "Pole nie może być puste!")
	@Size(max=5000, message = "Maksymalna ilość znaków to 5000!")
	private String details;
	

	/**
	 * Konstruktor domyslny
	 */
	public Place() {}

	//===== Getery i Setery =====
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Continent getContinent() {
		return continent;
	}
	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getJpg() {
		return jpg;
	}
	public void setJpg(String jpg) {
		this.jpg = jpg;
	}
	
	public String getJpgPath() {
		return jpgPath;
	}
	public void setJpgPath(String jpgPath) {
		this.jpgPath = jpgPath;
	}

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
