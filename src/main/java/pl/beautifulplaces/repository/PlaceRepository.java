package pl.beautifulplaces.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.beautifulplaces.entity.Place;

/**
 * 
 * @author Marcin
 *
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{

	List<Place> findAllByContinentId(Long id);
	
	/**
	 * 
	 * @param id - numer kontynentu
	 * @return - zweaca wszystkie miejsca dla danego kontynenty
	 */
	@Query(value="select * from places where continent_id = ?1 order by date desc", nativeQuery = true)
	List<Place> findAllByContinentIdOrderByDate(Long id);
}
