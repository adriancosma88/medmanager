package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findAll();
	List<User> findByUserName(String username);
	
}
