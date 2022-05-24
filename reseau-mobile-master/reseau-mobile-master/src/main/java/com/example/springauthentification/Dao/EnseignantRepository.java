package  com.example.springauthentification.Dao;


import  com.example.springauthentification.Entities.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EnseignantRepository extends CrudRepository<Enseignant,String>{
}
