package pl.beautifulplaces.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.beautifulplaces.entity.Continent;
import pl.beautifulplaces.entity.Place;
import pl.beautifulplaces.repository.PlaceRepository;
import pl.beautifulplaces.service.ContinentService;
import pl.beautifulplaces.service.PlaceService;

@Controller
@RequestMapping("/")
public class PlaceController {

	private PlaceService placeService;
	private ContinentService continentService;

	PlaceRepository placeRepository;

	@Autowired
	public PlaceController(PlaceService placeService, ContinentService continentService,
			PlaceRepository placeRepository) {
		this.placeService = placeService;
		this.continentService = continentService;
		this.placeRepository = placeRepository;
	}

	@ModelAttribute("continents")
	public List<Continent> getContinents() {
		return continentService.getContinents();
	}

	/***** Index *******************************/
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("africa", placeService.getPlacesByContinentId(1L));
		model.addAttribute("america", placeService.getPlacesByContinentId(2L));
		model.addAttribute("australia", placeService.getPlacesByContinentId(3L));
		model.addAttribute("asia", placeService.getPlacesByContinentId(4L));
		model.addAttribute("europe", placeService.getPlacesByContinentId(5L));
		return "index";
	}

	/***** Admin *******************************/
	@GetMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("africa", placeService.getPlacesByContinentId(1L));
		model.addAttribute("america", placeService.getPlacesByContinentId(2L));
		model.addAttribute("australia", placeService.getPlacesByContinentId(3L));
		model.addAttribute("asia", placeService.getPlacesByContinentId(4L));
		model.addAttribute("europe", placeService.getPlacesByContinentId(5L));
		return "admin";
	}

	/***** ADD *******************************/
	@GetMapping("/admin/addPost")
	public String addGet(Model model) {
		model.addAttribute("places", new Place());
		return "admin/addPost";
	}

	@PostMapping("/admin/addPost")
	public String addPost(@ModelAttribute Place place) {
		placeService.addToDB(place);
		return "redirect:/admin";
	}

	/***** EDIT *******************************/
	@GetMapping("/admin/edit/{id}")
	public String editGet(@PathVariable Long id, Model model) {
		System.out.println("====================================================================");
		// System.out.println("!!!!!!!!!!!" + placeService.getPlaceById(id));

		model.addAttribute("places", new Place());
		// model.addAttribute("places", placeRepository.findOne(id));
		// model.addAttribute("places", placeService.getPlaceById(id));

		return "admin/editPost";
	}

	@PostMapping("/admin/edit/{id}")
	public String editPost(@ModelAttribute Place place) {
		placeService.editDB(place);
		return "redirect:/admin";
	}

	/***** DELETE *******************************/
	@GetMapping("/admin/delete/{id}")
	public String delete(@PathVariable Long id) {
		placeService.deleteFromDB(id);
		return "redirect:/admin";
	}
}
