/**
 * 
 */
package com.owmanager.owmanager.team;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.owmanager.owmanager.user.User;

/**
 * Cette classe permet aux {@link User} de répondre aux {@link Research} posté
 * par les {@link Team}.
 */
public class ApplyFor {
	@JsonProperty
	private String battletag;
	@JsonProperty
	private String message;
	@JsonProperty
	private LocalDateTime creationDate;

	@JsonCreator
	public ApplyFor(String battletag, String message, LocalDateTime creationDate) {
		super();
		this.battletag = battletag;
		this.message = message;
		this.creationDate = creationDate;
	}

}
