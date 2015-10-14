package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByUserName (String userName);
	public User findFirstByUserName(String userName);
}
