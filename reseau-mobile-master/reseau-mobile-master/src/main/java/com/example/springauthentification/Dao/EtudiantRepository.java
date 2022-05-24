package com.example.springauthentification.Dao;

import com.example.springauthentification.Entities.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EtudiantRepository extends CrudRepository<Etudiant,String>{
}
