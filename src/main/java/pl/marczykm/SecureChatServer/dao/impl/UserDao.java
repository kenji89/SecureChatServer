package pl.marczykm.SecureChatServer.dao.impl;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marczykm.SecureChatServer.entity.User;

@Repository
@Table(name="Users")
public interface UserDao extends JpaRepository<User, String>{
	User findOneByUsername(String username);
}
