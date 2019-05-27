package pl.beautifulplaces.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="places")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	private Date date = new Date();
	
	@ManyToOne
	private Continent continent;
	
	@Column(columnDefinition = "mediumtext")
	private String jpg;
	

	public Place() {}
	
	public Place(Long id, String name, String description, Date date, Continent continent, String jpg) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.continent = continent;
		this.jpg = jpg; //!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

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

	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", continent="
				+ continent + ", jpg=" + jpg + "]";
	}
	
	
	
}
