package com.openclassrooms.springsecurityauth.Dao;


import com.openclassrooms.springsecurityauth.Entities.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface GuestRepository extends CrudRepository<Guest,String>{
}
