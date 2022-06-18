package com.openclassrooms.springsecurityauth.service;

import com.openclassrooms.springsecurityauth.Dao.UserRepository;
import com.openclassrooms.springsecurityauth.Entities.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

  /**
   * Instantiates a new User detail service.
   *
   * @param userRepository the user repository
   */
  public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userDetails = userRepository.findByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(userDetails.getUsername(),userDetails.getPassword(), new ArrayList<>());
    }
}
