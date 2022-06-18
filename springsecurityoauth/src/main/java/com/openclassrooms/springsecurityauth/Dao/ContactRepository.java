package com.openclassrooms.springsecurityauth.Dao;

import com.openclassrooms.springsecurityauth.Entities.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ContactRepository extends CrudRepository<Contact,String> {
}
