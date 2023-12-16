package io.github.rodrigojfagundes.carwork.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import io.github.rodrigojfagundes.carwork.entities.User;
import io.github.rodrigojfagundes.carwork.repositories.UserRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
	
	private UserRepository userRepository;
	
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, 
			OAuth2Authentication authentication) {
		
		User user = userRepository.findByUsername(authentication.getName());
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", user.getId());
		map.put("userName", user.getUsername());
		
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		
		token.setAdditionalInformation(map);
		
		return accessToken;
		
	}

}
