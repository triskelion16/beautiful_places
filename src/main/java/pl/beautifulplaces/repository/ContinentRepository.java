package pl.beautifulplaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.beautifulplaces.entity.Continent;

/**
 * 
 * @author Marcin
 *
 */
@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long>{

}
