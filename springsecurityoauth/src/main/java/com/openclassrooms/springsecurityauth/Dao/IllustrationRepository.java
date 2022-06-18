package com.openclassrooms.springsecurityauth.Dao;


import com.openclassrooms.springsecurityauth.Entities.Illustration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface IllustrationRepository extends CrudRepository<Illustration,String>{
}
