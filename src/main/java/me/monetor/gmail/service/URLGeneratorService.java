package me.monetor.gmail.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

public class URLGeneratorService {
	
	private final String CLIENT_ID = "1009235937530-8ebk66k2t7qfm72rl14mcmikkp2vaftn.apps.googleusercontent.com";
	private final String CLIENT_SECRET = "DnLzas6KlbCLWa_J7t5OnVbu";
	private final String REDIRECT_URI = "http://localhost";
	
	
	public URI getAuthURL() throws URISyntaxException{
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("accounts.google.com")
				.setPath("/o/oauth2/v2/auth")
				.setParameter("scope", "https://www.googleapis.com/auth/gmail.readonly")
				.setParameter("redirect_uri", REDIRECT_URI)
				.setParameter("response_type", "code")
				.setParameter("client_id", CLIENT_ID)
				.setParameter("access_type", "offline")
				.build();
		
		return uri;
	}
	
	public URI getTokenURL() throws URISyntaxException{
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.googleapis.com")
				.setPath("/oauth2/v4/token")
				.build();
		
		return uri;
	}
	
	public URI getMessageListURL(String userId, String searchQuery, String accessToken) throws URISyntaxException{
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.googleapis.com")
				.setPath("/gmail/v1/users/"+userId+"/messages")
				.setParameter("access_token", accessToken) 
				.setParameter("q", searchQuery)
				.build();
		
		return uri;
	}
	
	public URI getMessageURL(String userId, String messageId, String accessToken) throws URISyntaxException{
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.googleapis.com")
				.setPath("/gmail/v1/users/"+userId+"/messages/"+messageId)
				.setParameter("access_token", accessToken) 
				.build();
		
		return uri;
	}
	
	public List<NameValuePair> getTokenQueryParameters(String code){
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("code", code));
		urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
		urlParameters.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
		urlParameters.add(new BasicNameValuePair("redirect_uri", REDIRECT_URI));
		urlParameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
		
		return urlParameters;
	}
	
	public List<NameValuePair> getRefreshTokenQueryParameters(String refreshToken){
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
		urlParameters.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
		urlParameters.add(new BasicNameValuePair("refresh_token", refreshToken));
		urlParameters.add(new BasicNameValuePair("grant_type", "refresh_token"));
		
		return urlParameters;
	}
	
}
