/**
 * 
 */
package com.owmanager.owmanager.team;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.owmanager.owmanager.common.Availibility;
import com.owmanager.owmanager.user.Grade;
import com.owmanager.owmanager.user.Role;
import com.owmanager.owmanager.user.Spirit;

/**
 * Cette classe permet aux {@link Team} de mettre des annonces pour rechercher des joueurs. Les différents critères sont: la cote, l'état d'esprit du joueur,
 * le role et les disponibilités.
 */
@Document
public class Research {
	@Id
	@JsonProperty
	private String id;
	@JsonProperty
	private Grade grade;
	@JsonProperty
	private Spirit spirit;
	@JsonProperty
	private Role role;
	@JsonProperty
	private Set<Availibility> availibilities;
	@JsonProperty
	private List<ApplyFor> applies;

	@JsonCreator
	public Research(Grade grade, Spirit spirit, Role role, Set<Availibility> availibilities,List<ApplyFor> applies) {
		super();
		this.grade = grade;
		this.spirit = spirit;
		this.role = role;
		this.availibilities = availibilities;
		this.applies = applies;
	}

}
