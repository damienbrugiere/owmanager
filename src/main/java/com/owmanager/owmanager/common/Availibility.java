/**
 * 
 */
package com.owmanager.owmanager.common;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Damien
 *
 */
public class Availibility {
	@JsonProperty
	private Day day;
	@JsonProperty
	private Set<Period> periods;
	@JsonCreator
	public Availibility(@JsonProperty("day") Day day,@JsonProperty("periods") Set<Period> periods) {
		this.day = day;
		this.periods = periods;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((day == null) ? 0 : day.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Availibility other = (Availibility) obj;
//		if (day == null) {
//			if (other.day != null)
//				return false;
//		} else if (!day.equals(other.day))
//			return false;
//		return true;
//	}
//	
}
