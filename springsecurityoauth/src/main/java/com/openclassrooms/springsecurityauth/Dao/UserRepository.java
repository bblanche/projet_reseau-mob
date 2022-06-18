package com.openclassrooms.springsecurityauth.Dao;

import com.openclassrooms.springsecurityauth.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Find by username user.
   *
   * @param username the name
   * @return the user
   */
  User findByUsername(String username);
}