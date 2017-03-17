package firstboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import firstboot.model.Person;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long>{

}
