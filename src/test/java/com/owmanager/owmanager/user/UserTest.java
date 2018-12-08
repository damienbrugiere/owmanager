/**
 * 
 */
package com.owmanager.owmanager.user;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owmanager.owmanager.common.Availibility;
import com.owmanager.owmanager.common.Day;
import com.owmanager.owmanager.common.Period;

/**
 * @author Damien
 *
 */
public class UserTest {

	@Test
	public void test() throws JsonProcessingException {
		Assertions.assertThat(new ObjectMapper().writeValueAsString(new User("battletag",new HashSet<>(Arrays.asList(Role.FLANKER)), "team", null, Spirit.FUN, new HashSet<>(Arrays.asList(new Availibility(Day.FRIDAY,new HashSet<>(Arrays.asList(Period.AFTERNOON)))))))).isEqualTo("{\"battletag\":\"battletag\",\"roles\":[\"FLANKER\"],\"team\":\"team\",\"coachingTeam\":null,\"spirit\":\"FUN\",\"availabilities\":[{\"day\":\"FRIDAY\",\"periods\":[\"AFTERNOON\"]}]}");
	}

	@Test
	public void test1() throws IOException {
		User user = new ObjectMapper().readValue("{\"battletag\":\"battletag\",\"roles\":[\"FLANKER\"],\"team\":\"team\",\"coachingTeam\":null,\"spirit\":\"FUN\",\"availabilities\":null}",User.class);
		Assertions.assertThat(user).isEqualToComparingFieldByFieldRecursively(new User("battletag",new HashSet<>(Arrays.asList(Role.FLANKER)), "team", null, Spirit.FUN,null));
	}
}
