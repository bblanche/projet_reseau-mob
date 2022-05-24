package  com.example.springauthentification.Dao;

import  com.example.springauthentification.Entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ContactRepository extends CrudRepository<Contact,String> {
}
