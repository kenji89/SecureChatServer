package pl.marczykm.SecureChatServer.dao.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.marczykm.SecureChatServer.entity.User;

public interface UserDao extends MongoRepository<User, String>{
	User findOneByUsername(String username);
}
