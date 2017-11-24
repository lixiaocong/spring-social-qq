/**
 * 
 */
package com.lixiaocong.social.qq.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lixiaocong.social.qq.api.QQ;
import com.lixiaocong.social.qq.api.UserOperations;
import com.lixiaocong.social.qq.api.impl.json.QQModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QQTemplate extends AbstractOAuth2ApiBinding implements QQ {
	
	private static final String openIdUrl="https://graph.qq.com/oauth2.0/me";
	
	private UserOperations userOperations;
	private ObjectMapper objectMapper;

	@SuppressWarnings("unused")
	public QQTemplate(String appId, String accessToken) {
		super(accessToken);
				
		String callback=getRestTemplate().getForObject(openIdUrl+"?access_token="+ accessToken, String.class);
		String startKey="\"openid\":\"";
		String endKey="\"";
		
		int start=callback.indexOf(startKey);
		int end=callback.indexOf(endKey, start+startKey.length());
		
		String openId=callback.substring(start+startKey.length(), end);
			
		initialize(appId, openId,accessToken );
	}

	public QQTemplate() {
		// TODO Auto-generated constructor stub
	}

	private void initialize(String appId, String openId,  String token) {
		userOperations = new UserTemplate(this, getRestTemplate(),
				isAuthorized(), appId, openId, token);
	}

	/**
	 * @return the userOperations
	 */

	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = super
				.getJsonMessageConverter();
		List<MediaType> list = new ArrayList<MediaType>();
		list.addAll(converter.getSupportedMediaTypes());
		list.add(MediaType.TEXT_PLAIN);
		list.add(MediaType.APPLICATION_JSON);
		list.add(MediaType.TEXT_HTML);
		list.add(new MediaType("text","x-javascript",Charset.forName("UTF-8")));
		converter.setSupportedMediaTypes(list);

		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new QQModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

}
