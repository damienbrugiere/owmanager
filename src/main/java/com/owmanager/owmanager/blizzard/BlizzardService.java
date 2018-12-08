/**
 * 
 */
package com.owmanager.owmanager.blizzard;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.owmanager.owmanager.user.User;

/**
 * @author Damien
 *
 */
@Service
public class BlizzardService {
	@Autowired
	private RestTemplate restTemplate;

	public User connectUserWithBlizzardLogin(String code) {
		HttpEntity<String> headers = new HttpEntity<>(
				createHeaders("bb16157ae2f5472a980130b3d63e2712", "oFk6uO94leo0t3VWKY5SqRgbKbWsOwko"));
		ResponseEntity<Token> tokenEntity = this.restTemplate
				.exchange("https://eu.battle.net/oauth/token?grant_type=authorization_code&code=" + code
						+ "&redirect_uri=http://localhost:4200/", HttpMethod.GET, headers, Token.class);
		User user = this.restTemplate.getForObject("https://eu.battle.net/oauth/userinfo?access_token="+tokenEntity.getBody().getAccess_token(), User.class);
		return user;
	}

	private HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = org.apache.tomcat.util.codec.binary.Base64
						.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
	
	
}
