package pl.beautifulplaces.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Marcin
 *
 * Hibernate - tabela: continents
 */
@Entity
@Table(name="continents")
public class Continent {

	// Hibernate - kolumna: id | klucz główny | automatyczna inkrementacja
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Hibernate - kolumna: name | pozycja wymagana 
	@Column(nullable = false)
	private String name;

	// Hibernate - kolumna: places | relacja jeden do wielu z tabelą: places
	@OneToMany(mappedBy	= "continent")
	private List<Place> places;

	/**
	 * Konstruktor domyslny
	 */
	public Continent() {}
	
	public Continent(Long id, String name, List<Place> places) {
		this.id = id;
		this.name = name;
		this.places = places;
	}
	
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

	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
}
