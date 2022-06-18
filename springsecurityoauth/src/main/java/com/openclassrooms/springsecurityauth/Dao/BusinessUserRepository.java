package com.openclassrooms.springsecurityauth.Dao;


import com.openclassrooms.springsecurityauth.Entities.BusinessUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BusinessUserRepository extends  CrudRepository<BusinessUser,String> {
}
