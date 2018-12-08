/**
 * 
 */
package com.owmanager.owmanager.user;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.owmanager.owmanager.common.Availibility;
import com.owmanager.owmanager.common.CreationUser;
import com.owmanager.owmanager.common.Entitable;

/**
 * @author Damien
 *
 */
@Document
public class User implements Entitable {
	@Id
	@JsonProperty
	@NotEmpty(groups = CreationUser.class)
	private String battletag;
	@JsonProperty
	@Null(groups = CreationUser.class)
	private Set<Role> roles;
	@JsonProperty
	@Null(groups = CreationUser.class)
	private String team;
	@JsonProperty
	@Null(groups = CreationUser.class)
	private String coachingTeam;
	@JsonProperty
	@Null(groups = CreationUser.class)
	private Spirit spirit;
	@JsonProperty
	@Null(groups = CreationUser.class)
	private Set<Availibility> availabilities;

	@PersistenceConstructor
	@JsonCreator
	public User(@JsonProperty("battletag") String battletag, @JsonProperty("roles") Set<Role> roles,
			@JsonProperty("team") String team, @JsonProperty("coachingTeam") String coachingTeam,
			@JsonProperty("spirit") Spirit spirit, @JsonProperty("availabilities") Set<Availibility> availabilities) {
		this.battletag = battletag;
		this.roles = roles==null ? new HashSet<>() : roles;
		this.team = team;
		this.coachingTeam = coachingTeam;
		this.spirit = spirit;
		this.availabilities = availabilities==null ? new HashSet<>() : availabilities;
	}

	@Transient
	@JsonIgnore
	public String getBattletag() {
		return battletag;
	}

	@Override
	public Serializable getMongoId() {
		return this.battletag;
	}

}
