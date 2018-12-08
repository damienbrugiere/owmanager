/**
 * 
 */
package com.owmanager.owmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.owmanager.owmanager.common.GenericService;

/**
 * @author Damien
 *
 */
@Service
public class UserService extends GenericService<User,String> {
	@Autowired
	private UserRepository userRepository;

	@Override
	protected MongoRepository<User, String> repository() {
		return userRepository;
	}
}
