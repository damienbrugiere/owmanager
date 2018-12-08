package com.owmanager.owmanager.common;

import java.beans.Transient;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * Interface pour identifier et avoir les informations primordiales de mes objets persistables
 *
 */
public interface Entitable {
	 @Transient
	 @JsonIgnore
	Serializable getMongoId();
}
