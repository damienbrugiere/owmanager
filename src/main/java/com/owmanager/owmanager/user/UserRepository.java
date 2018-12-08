/**
 * 
 */
package com.owmanager.owmanager.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Damien
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
