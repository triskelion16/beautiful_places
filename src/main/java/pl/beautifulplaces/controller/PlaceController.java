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

	/**
	 * Konstruktor - wstrzykiwanie zależności
	 * 
	 * @param placeService - instancja klasy PlaceService
	 * @param continentService - instancja klasy ContinentService
	 */
	@Autowired
	public PlaceController(PlaceService placeService, ContinentService continentService) {
		this.placeService = placeService;
		this.continentService = continentService;
	}

	/**
	 * 
	 * @return - zwraca listę kontynentów pobraną z bazy danych
	 */
	@ModelAttribute("continents")
	public List<Continent> getContinents() {
		return continentService.getContinents();
	}

	/***** Index *******************************/
	/**
	 * Mapowanie adresu "/" 
	 * 
	 * @param model - dodanie atrybutów do widoku pobranych z bazy danych
	 * @return - wyświetlenie widoku index.jsp
	 */
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
	/**
	 * Mapowanie adresu "/admin" 
	 * Akcja dostępna po zalogowaniu
	 * 
	 * @param model - dodanie atrybutów do widoku pobranych z bazy danych
	 * @return - wyświetlenie widoku admin.jsp
	 */
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
	/**
	 * Mapowanie adresu "/admin/addPost" - wyświetlenie formularza
	 * Akcja dostępna po zalogowaniu
	 * 
	 * @param model - dodanie atrybutu dla nowej instancji klasy Place
	 * @return - wyświetlenie widoku addPost.jsp
	 */
	@GetMapping("/admin/addPost")
	public String addGet(Model model) {
		model.addAttribute("places", new Place());
		return "admin/addPost";
	}

	/**
	 * Mapowanie adresu "/admin/addPost" - przesłanie formularza
	 * Akcja dostępna po zalogowaniu 
	 * 
	 * @param place - obiekt klasy Place przekazany do zapisania w bazie danych 
	 * @param result - instancja klasy do walidacji formularzy
	 * @return - wyświetlenie widoku admin.jsp - jeśli formularz poprawnie wypełniony
	 * @return - powrót do widoku addPost.jsp - jeśli formularz niepoprawnie wypełniony
	 */
	@PostMapping("/admin/addPost")
	public String addPost(@Valid @ModelAttribute("places") Place place, BindingResult result) {
		if(result.hasErrors()) {
			return "/admin/addPost";
		}
		
		placeService.addToDB(place);
		return "redirect:/admin";
	}

	/***** EDIT *******************************/
	/**
	 * Mapowanie adresu "/admin/edit/{id}" - wyświetlenie formularza
	 * Akcja dostępna po zalogowaniu 
	 * 
	 * @param id - identyfikator rekordu w bazie danych
	 * @param model - dodanie atrybutu dla edytowanej instancji klasy Place
	 * @return - wyświetlenie widoku editPost.jsp
	 */
	@GetMapping("/admin/edit/{id}")
	public String editGet(@PathVariable Long id, Model model) {
		model.addAttribute("places", placeService.getPlaceById(id));

		return "admin/editPost";
	}

	/**
	 * Mapowanie adresu "/admin/edit/{id}" - przesłanie formularza
	 * Akcja dostępna po zalogowaniu 
	 * 
	 * @param place - obiekt klasy Place przekazany do zapisania w bazie danych 
	 * @param result - instancja klasy do walidacji formularzy
	 * @return - wyświetlenie widoku admin.jsp - jeśli formularz poprawnie wypełniony
	 * @return - powrót do widoku editPost.jsp - jeśli formularz niepoprawnie wypełniony
	 */
	@PostMapping("/admin/edit/{id}")
	public String editPost(@Valid @ModelAttribute("places") Place place, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/editPost";
		}
		
		placeService.editDB(place);
		return "redirect:/admin";
	}

	/***** DELETE *******************************/
	/**
	 * Mapowanie adresu "/admin/delete/{id}" - przesłanie formularza
	 * Akcja dostępna po zalogowaniu 
	 * 
	 * @param id - identyfikator rekordu w bazie danych
	 * @return - wyświetlenie widoku admin.jsp
	 */
	@GetMapping("/admin/delete/{id}")
	public String delete(@PathVariable Long id) {
		placeService.deleteFromDB(id);
		return "redirect:/admin";
	}
	
	/***** DETAILS *******************************/
	/**
	 * Mapowanie adresu "/admin/delete/{id}" - przesłanie formularza
	 * 
	 * @param id - identyfikator rekordu w bazie danych
	 * @param model - dodanie atrybutu do widoku pobranego z bazy danych
	 * @return - wyświetlenie widoku details.jsp
	 */
	@GetMapping("/details/{id}")
	public String detailsGet(@PathVariable Long id, Model model) {
		model.addAttribute("places", placeService.getPlaceById(id));

		return "details";
	}
}
