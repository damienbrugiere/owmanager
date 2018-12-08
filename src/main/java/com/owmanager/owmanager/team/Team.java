/**
 * 
 */
package com.owmanager.owmanager.team;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.owmanager.owmanager.user.User;

/**
 * Tout simplement la représentation de l'équipe.
 *
 */
@Document
public class Team {
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
	@DBRef
	@JsonProperty
	private Set<User> players;
	@JsonProperty
	private User coach;
	@JsonProperty
	private boolean searching;
	@JsonProperty
	@DBRef
	private List<Research> wanteds;

	@JsonCreator
	public Team(String id, String name, Set<User> players, User coach, boolean searching) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
		this.coach = coach;
		this.searching = searching;
	}

}
