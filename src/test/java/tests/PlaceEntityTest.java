/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import pl.beautifulplaces.entity.Continent;
import pl.beautifulplaces.entity.Place;

/**
 * @author Sebastian
 *
 */
public class PlaceEntityTest {
	Place place = new Place();
	Continent continent = new Continent(5L, "Europa", null);
	String jpg = "/9j/2wBDAAYEBQYFBAYGBQYHBwYIChAK";
	String jpgPath = "/home/triskelion/Obrazy/BeautifulPlaces-Images/jpg1.jpg";
	
	/**
	 * @see {@link pl.beautifulplaces.entity}
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		place.setId(100L);
		place.setName("Warszawa");
		place.setDescription("Bardzo krótki opis miejsca");
		place.setContinent(continent);
		place.setDate(new Date());
		place.setJpg(jpg);
		place.setJpgPath(jpgPath);
	}

	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getId()}.
	 */
	@Test
	public void testGetId() {
		Long expectedPlaceID = (long) 100;
		assertTrue(expectedPlaceID.equals(place.getId()));
	}

	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getName()}.
	 */
	@Test
	public void testGetName() {
		String expectedName = "Warszawa";
		assertTrue(expectedName.equals(place.getName()));
	}

	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		String expectedDescription = "Bardzo krótki opis miejsca";
		assertTrue(expectedDescription.equals(place.getDescription()));
	}

	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getContinent()}.
	 */
	@Test
	public void testGetContinent() {
		String expectedContinent = "Europa";
		assertTrue(expectedContinent.equals(place.getContinent().getName()));
	}

	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getDate()}.
	 */
	@Test
	public void testGetDate() {
		assertTrue(!place.getDate().equals(null));
	}
	
	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getJpg()}.
	 */
	@Test
	public void testGetJpg() {
		String expectedJpgString = "/9j/2wBDAAYEBQYFBAYGBQYHBwYIChAK";
		assertTrue(expectedJpgString.equals(place.getJpg()));
	}
	
	/**
	 * Test method for {@link pl.beautifulplaces.entity.Place#getJpgPath()}.
	 */
	@Test
	public void testGetJpgPath() {
		String expectedJpgPathString = "/home/triskelion/Obrazy/BeautifulPlaces-Images/jpg1.jpg";
		assertTrue(expectedJpgPathString.equals(place.getJpgPath()));
	}
}
