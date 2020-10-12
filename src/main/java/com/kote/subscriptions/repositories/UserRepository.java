package com.kote.subscriptions.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kote.subscriptions.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

	//Este método recupera todos los usuarios de la base de datos
    List<User> findAll();
    
	User findByEmail(String email);

	User findById(Integer id);

}
