package com.example.springauthentification.Dao;


import com.example.springauthentification.Entities.BusinessUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BusinessUserRepository extends  CrudRepository<BusinessUser,String> {
}
