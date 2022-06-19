package com.openclassrooms.springsecurityauth;

import java.security.Principal;
import java.sql.Date;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;



@RestController
public class LoginController {

   //augmenté-------------------------------------------------------------------
   public static final String SECRET = "121341werw244234w25234wewerwerwer";
   public static final long EXPIRATION_TIME = 86400000; // 1 days
   public static final String TOKEN_PREFIX = "Bearer ";
   public static final String HEADER_STRING = "Authorization";
   //----------------------------------------------------------------------------------------
 
   private final  OAuth2AuthorizedClientService  authorizedClientService;

   public LoginController(OAuth2AuthorizedClientService authorizedClientService) {
      this.authorizedClientService = authorizedClientService;
   }
   
    @RolesAllowed("USER")
    @RequestMapping("/*")
    /*public String getUserInfo(Principal user) {
      StringBuffer userInfo= new StringBuffer();
       if(user instanceof UsernamePasswordAuthenticationToken){
            userInfo.append(getUsernamePasswordLoginInfo(user));
         }
         else if(user instanceof OAuth2AuthenticationToken){
            userInfo.append(getOauth2LoginInfo(user));
             }
         return userInfo.toString();
       }

   private StringBuffer getUsernamePasswordLoginInfo(Principal user)
   {
      StringBuffer usernameInfo = new StringBuffer();
      
      UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
      if(token.isAuthenticated()){
         User u = (User) token.getPrincipal();
         usernameInfo.append("Welcome, " + u.getUsername());
      }
      else{
         usernameInfo.append("NA");
      }
      return usernameInfo;
   }*/
  private StringBuffer getOauth2LoginInfo(Principal user){

      StringBuffer protectedInfo = new StringBuffer();
      
      OAuth2User principal = ((OAuth2AuthenticationToken) user).getPrincipal(); //oAUTH2

      OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
      OAuth2AuthorizedClient authClient = this.authorizedClientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
      
      if(authToken.isAuthenticated()){
         protectedInfo.append("Oauth--------------------------------------------------------------------------------");

         Map<String,Object> userAttributes = ((DefaultOAuth2User) authToken.getPrincipal()).getAttributes();
         
         String userToken = authClient.getAccessToken().getTokenValue();
         protectedInfo.append("Welcome, " + userAttributes.get("name")+"<br><br>");
         protectedInfo.append("e-mail: " + userAttributes.get("email")+"<br><br>");
         protectedInfo.append("Access Token: " + userToken+"<br><br>");

         
         for (String key : userAttributes.keySet()) {
         protectedInfo.append("  " + key + ": " + userAttributes.get(key)+"<br>");
         }
      }
      else{
      protectedInfo.append("NA");
      }
      //Pour openId
      OidcIdToken idToken = getIdToken(principal);
      protectedInfo.append("OpenId------------------------------------------------------------------------");
      if(idToken != null) {

         protectedInfo.append("idToken value: " + idToken.getTokenValue()+"<br><br>");
         protectedInfo.append("Token mapped values <br><br>");
         
         Map<String, Object> claimsOpenId = idToken.getClaims();
      
            for (String key : claimsOpenId.keySet()) {
            protectedInfo.append("  " + key + ": " + claimsOpenId.get(key)+"<br>");
            }
      }
   return protectedInfo;
   }

   private OidcIdToken getIdToken(OAuth2User principal){
      if(principal instanceof DefaultOidcUser) {
        DefaultOidcUser oidcUser = (DefaultOidcUser)principal;
        return oidcUser.getIdToken();
      }
      return null;
   }
   
   
   

}