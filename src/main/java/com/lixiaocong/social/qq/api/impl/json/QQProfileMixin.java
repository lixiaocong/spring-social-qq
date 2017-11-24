package com.lixiaocong.social.qq.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class QQProfileMixin {

	@JsonCreator
	QQProfileMixin(
			@JsonProperty("nickname") String nickName,
			@JsonProperty("figureurl") String figureUrl,
			@JsonProperty("gender") String gender,
			@JsonProperty("vip") int vip,
			@JsonProperty("level") int level) {
	}

}
