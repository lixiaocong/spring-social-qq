/**
 * 
 */
package com.lixiaocong.social.qq.api;

import org.springframework.social.ApiBinding;

/**
 * @author alexzuo
 *
 */
public interface QQ extends ApiBinding {

	public abstract UserOperations userOperations();
	
}
