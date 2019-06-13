package pl.beautifulplaces.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.beautifulplaces.entity.Continent;
import pl.beautifulplaces.entity.Place;
import pl.beautifulplaces.service.ContinentService;
import pl.beautifulplaces.service.PlaceService;

/**
 * 
 * @author Sebastian
 *
 * Mapowanie adresów URL
 */
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
	public String addPost(@Valid @ModelAttribute("places") Place place, BindingResult result) {
		if(result.hasErrors()) {
			return "/admin/addPost";
		}
		
		placeService.addToDB(place);
		return "redirect:/admin";
	}

	/***** EDIT *******************************/
	@GetMapping("/admin/edit/{id}")
	public String editGet(@PathVariable Long id, Model model) {
		model.addAttribute("places", placeService.getPlaceById(id));

		return "admin/editPost";
	}

	@PostMapping("/admin/edit/{id}")
	public String editPost(@Valid @ModelAttribute("places") Place place, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/editPost";
		}
		
		placeService.editDB(place);
		return "redirect:/admin";
	}

	/***** DELETE *******************************/
	@GetMapping("/admin/delete/{id}")
	public String delete(@PathVariable Long id) {
		placeService.deleteFromDB(id);
		return "redirect:/admin";
	}
	
	/***** DETAILS *******************************/
	@GetMapping("/details/{id}")
	public String detailsGet(@PathVariable Long id, Model model) {
		model.addAttribute("places", placeService.getPlaceById(id));

		return "details";
	}
}
