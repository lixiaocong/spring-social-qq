/**
 * 
 */
package com.lixiaocong.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.lixiaocong.social.qq.api.QQ;

/**
 * @author alexzuo
 * 
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String clientId, String clientSecret) {
		super("qq", new QQServiceProvider(clientId, clientSecret),
				new QQAdapter());
	}

}
