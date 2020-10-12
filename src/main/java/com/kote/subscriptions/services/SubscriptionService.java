package com.kote.subscriptions.services;

import org.springframework.stereotype.Service;

import com.kote.subscriptions.models.Subscription;
import com.kote.subscriptions.repositories.SubscriptionRepository;

@Service
public class SubscriptionService {
	private final SubscriptionRepository subsRepo;

	public SubscriptionService(SubscriptionRepository subsRepo) {
        this.subsRepo = subsRepo;
    }

	public Subscription findSubsByUserId(Long id) {
		return subsRepo.findByUserId(id);
	}

}
