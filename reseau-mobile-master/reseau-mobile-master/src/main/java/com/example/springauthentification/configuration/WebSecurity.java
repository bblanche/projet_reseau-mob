package com.example.springauthentification.configuration;

import com.example.springauthentification.security.JWTAuthenticationFilter;
import com.example.springauthentification.security.AuthorizationFilter;
import com.example.springauthentification.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

  public static final String SIGN_UP_URL = "/api/v1/users";

  @Autowired private UserDetailServiceImpl userDetailService;

  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

  public WebSecurity(
      UserDetailServiceImpl userDetailService) {
    this.userDetailService = userDetailService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests() // Add a new custom security filter
        .antMatchers(HttpMethod.POST, SIGN_UP_URL)
        .permitAll() // Only Allow Permission for create user endpoint
        .anyRequest()
        .authenticated()
        .and()
        .addFilter(this.getJWTAuthenticationFilter()) // Add JWT Authentication Filter
        .addFilter(
            new AuthorizationFilter(authenticationManager())) // Add JWT Authorization Filter
        .sessionManagement()
        .sessionCreationPolicy(
            SessionCreationPolicy.STATELESS); // this disables session crea&tion on Spring Security
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration(
        "/**",
        new CorsConfiguration()
            .applyPermitDefaultValues()); // Allow/restrict our CORS permitting requests from any
                                          // source
    return source;
  }

  public JWTAuthenticationFilter getJWTAuthenticationFilter() throws Exception {
    final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
    filter.setFilterProcessesUrl("/api/v1/auth/login"); // override the default spring login url
    System.out.println(filter);
    return filter;
  }
}
