package com.kote.subscriptions.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kote.subscriptions.models.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long>{

	Subscription findByUserId(Long id);

}
