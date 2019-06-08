package pl.beautifulplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.beautifulplaces.entity.Continent;
import pl.beautifulplaces.repository.ContinentRepository;

/**
 * 
 * @author Sebastian
 *
 */
@Service
public class ContinentService {

	private ContinentRepository continentRepository;

	@Autowired
	public ContinentService(ContinentRepository continentRepository) {
		this.continentRepository = continentRepository;
	}
	
	@Transactional
	public List<Continent> getContinents() {
		return continentRepository.findAll();
	}
}
