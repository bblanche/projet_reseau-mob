package com.example.springauthentification.Dao;


import com.example.springauthentification.Entities.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeywordRepository  extends  CrudRepository<Keyword,String>{
}


