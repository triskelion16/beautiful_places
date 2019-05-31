package pl.beautifulplaces.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.beautifulplaces.entity.Place;
import pl.beautifulplaces.repository.PlaceRepository;

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
		
//		for (Place place : places) {
//			if (place.getJpg() != null) {
//				String jpg = place.getJpg();
//				place.setJpgByteArray(decoder(jpg));
//			}
//		}

		return places;
	}

	@Transactional
	public void addToDB(Place place) {
		if (place.getJpgPath() != null) {
			String imagePath = place.getJpgPath();
			place.setJpg(encoder(imagePath));
		}
		
//		File jpgPath = new File(place.getJpgPath());
//		try {
//			byte[] jpg = Files.readAllBytes(jpgPath.toPath());
//			place.setJpg(jpg);
//		} catch (IOException e) {
//			System.out.println("ERROR-------------------");
//			e.printStackTrace();
//		}
				
		//byte[] jpg = place.getJpg();
		System.out.println("====================================================================");
		System.out.println(place.toString());
		
		placeRepository.save(place);
	}
	
	@Transactional
	public void editDB(Place place) {
		if (place.getJpgPath() != null) {
			String imagePath = place.getJpgPath();
			place.setJpg(encoder(imagePath));
		}
		
		placeRepository.save(place);
	}

	@Transactional
	public Place getPlaceById(Long id) {

		System.out.println("++++++++++++++++++++++++++++++++" + id);
		
		//System.out.println(placeRepository.findOne(id));
		Place place = placeRepository.findOne(id);
		//String jpg = place.getJpg();

		//product.setJpgFile(decoder(jpg));

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

	/******* String to JPG converter **************/
	public static byte[] decoder(String base64Image) {

		byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
		return imageByteArray;
	}

}
