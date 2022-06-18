package com.openclassrooms.springsecurityauth.Dao;


import com.openclassrooms.springsecurityauth.Entities.Keyword;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeywordRepository  extends  CrudRepository<Keyword,String>{
}


