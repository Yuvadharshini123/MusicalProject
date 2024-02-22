package com.musical.project.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.musical.project.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findById(Long userId);



	

	//User findByuserUserId(String userUserId);

	//User findByName(String name);

	


	


}
