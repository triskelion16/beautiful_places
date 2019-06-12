package pl.beautifulplaces.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.beautifulplaces.entity.Place;
import pl.beautifulplaces.repository.PlaceRepository;

/**
 * 
 * @author Sebastian
 *
 */
@Service
public class PlaceService {

	private PlaceRepository placeRepository;

	@Autowired
	public PlaceService(PlaceRepository placeRepository) {
		this.placeRepository = placeRepository;
	}

	@Transactional
	public List<Place> getPlacesByContinentId(Long id) {
		List<Place> places = placeRepository.findAllByContinentIdOrderByDate(id);
		return places;
	}

	@Transactional
	public void addToDB(Place place) {
		if (place.getJpgPath() != null) {
			String imagePath = place.getJpgPath();
			place.setJpg(encoder(imagePath));
		}
//		String imagePath = place.getJpgPath();
//		place.setJpg(encoder(imagePath));
		
		placeRepository.save(place);
	}
	
	@Transactional
	public void editDB(Place place) {
		if (place.getJpgPath() != null) {
			String imagePath = place.getJpgPath();
			place.setJpg(encoder(imagePath));
		}
//		String imagePath = place.getJpgPath();
//		place.setJpg(encoder(imagePath));
		
		placeRepository.save(place);
	}

	@Transactional
	public Place getPlaceById(Long id) {
		Place place = placeRepository.findOne(id);
		return place;
	}

	@Transactional
	public void deleteFromDB(Long id) {
		placeRepository.delete(id);
	}

	/******** JPG to String converter ************/
	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);

		try (FileInputStream imageInFile = new FileInputStream(file)) {
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}

}
