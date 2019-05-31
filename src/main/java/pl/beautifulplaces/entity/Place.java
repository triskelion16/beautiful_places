package pl.beautifulplaces.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="places")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(length=500)
	private String description;
	private Date date = new Date();
	
	@ManyToOne
	private Continent continent;
	
	@Column(columnDefinition = "mediumtext")
	private String jpg;
	
	@Transient
	private String jpgPath;
	
	@Transient
	private byte[] jpgByteArray;
	

	public Place() {}
	
	public Place(Long id, String name, String description, Date date, Continent continent, String jpg, String jpgPath, byte[] jpgByteArray) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.continent = continent;
		this.jpg = jpg; //!!!!!!!!!!!!!!!!!!!!!!!!!!
		this.jpgPath = jpgPath;
		this.jpgByteArray = jpgByteArray;
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
	
	public String getJpgPath() {
		return jpgPath;
	}
	public void setJpgPath(String jpgPath) {
		this.jpgPath = jpgPath;
	}

	public byte[] getJpgByteArray() {
		return jpgByteArray;
	}
	public void setJpgByteArray(byte[] jpgByteArray) {
		this.jpgByteArray = jpgByteArray;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", continent="
				+ continent + ", jpg=" + jpg + ", jpgPath=" + jpgPath + ", jpgByteArray="
				+ Arrays.toString(jpgByteArray) + "]";
	}
	
	
	
}
