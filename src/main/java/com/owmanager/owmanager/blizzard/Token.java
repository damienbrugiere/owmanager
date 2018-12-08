package com.owmanager.owmanager.blizzard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
	@JsonProperty
	private String access_token;

	@JsonCreator
	public Token(@JsonProperty("access_token") String access_token) {
		this.access_token = access_token;
	}

	public String getAccess_token() {
		return access_token;
	}

}
