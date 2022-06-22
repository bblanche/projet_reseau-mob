package com.openclassrooms.springsecurityauth;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;




@RestController
public class LoginController {

  
   private final  OAuth2AuthorizedClientService  authorizedClientService;

   public LoginController(OAuth2AuthorizedClientService authorizedClientService) {
      this.authorizedClientService = authorizedClientService;
   }
   
    @RequestMapping("/*")
    
  private StringBuffer getOauth2LoginInfo(Principal user){ //Retourne un buffer contenant les informations de l'utililisateur

      StringBuffer protectedInfo = new StringBuffer();
      
      OAuth2User principal = ((OAuth2AuthenticationToken) user).getPrincipal(); //oAUTH2

      OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
      OAuth2AuthorizedClient authClient = this.authorizedClientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
      
      if(authToken.isAuthenticated()){
         protectedInfo.append("Oauth--------------------------------------------------------------------------------");

         Map<String,Object> userAttributes = ((DefaultOAuth2User) authToken.getPrincipal()).getAttributes();
         
         String userToken = authClient.getAccessToken().getTokenValue(); //token d'Oauth2 renvoyé par le RS une fois l'authentification validée
         protectedInfo.append("Access Token: " + userToken);

         
         for (String key : userAttributes.keySet()) {
         protectedInfo.append("  " + key + ": " + userAttributes.get(key));
         }
      }
      else{
      protectedInfo.append("NA");
      }
      //Pour openId
      OidcIdToken idToken = getIdToken(principal); //token d'OpenID renvoyé par le RS une fois l'authentification validée
      protectedInfo.append("OpenId------------------------------------------------------------------------");
      if(idToken != null) {

         protectedInfo.append("idToken value: " + idToken.getTokenValue());
         protectedInfo.append("Token mapped values <br><br>");
         
         Map<String, Object> claimsOpenId = idToken.getClaims();
      
            for (String key : claimsOpenId.keySet()) {
            protectedInfo.append("  " + key + ": " + claimsOpenId.get(key));
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