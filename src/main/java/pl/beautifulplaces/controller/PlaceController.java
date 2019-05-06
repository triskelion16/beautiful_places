package pl.beautifulplaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.beautifulplaces.entity.Continent;
import pl.beautifulplaces.entity.Place;
import pl.beautifulplaces.service.ContinentService;
import pl.beautifulplaces.service.PlaceService;

@Controller
@RequestMapping("/")
public class PlaceController {

	private PlaceService placeService;
	private ContinentService continentService;

	@Autowired
	public PlaceController(PlaceService placeService, ContinentService continentService) {
		this.placeService = placeService;
		this.continentService = continentService;
	}
	
	
	@ModelAttribute("continents")
	public List<Continent> getContinents() {
		return continentService.getContinents();
	}

	/***** Index *******************************/
	@GetMapping("/index")
	public String homePage(Model model) {
		model.addAttribute("africa", placeService.getPlacesByContinentId(1L));
		model.addAttribute("america", placeService.getPlacesByContinentId(2L));
		model.addAttribute("australia", placeService.getPlacesByContinentId(3L));
		model.addAttribute("asia", placeService.getPlacesByContinentId(4L));
		model.addAttribute("europe", placeService.getPlacesByContinentId(5L));
		return "index";
	}

	/***** ADD *******************************/
	@GetMapping("/add")
	public String addGet(Model model) {
		model.addAttribute("places", new Place());
		return "add";
	}
	
	@PostMapping("/add")
	public String addPost(@ModelAttribute Place place) {
		placeService.addToDB(place);
		return "redirect:/index";
	}
	
	/***** EDIT *******************************/
	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Long id, Model model) {
		model.addAttribute("places", placeService.getPlaceById(id));
		return "add";
	}
	
	@PostMapping("/edit/{id}")
	public String editPost(@ModelAttribute Place place) {
		placeService.editDB(place);
		return "redirect:/index";
	}
	
	/***** DELETE *******************************/
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		placeService.deleteFromDB(id);
		return "redirect:/index";
	}
}
