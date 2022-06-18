package com.openclassrooms.springsecurityauth.Dao;


import com.openclassrooms.springsecurityauth.Entities.Enseignant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EnseignantRepository extends CrudRepository<Enseignant,String>{
}