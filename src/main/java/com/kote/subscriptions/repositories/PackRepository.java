package com.kote.subscriptions.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kote.subscriptions.models.Pack;

@Repository
public interface PackRepository extends CrudRepository<Pack, Long>{

    List<Pack> findAll();

	Pack findByName(String name);

}
