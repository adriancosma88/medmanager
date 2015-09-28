package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserName (String userName);
}
