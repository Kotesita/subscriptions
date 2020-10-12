package com.kote.subscriptions.services;

import org.springframework.stereotype.Service;

import com.kote.subscriptions.models.Role;
import com.kote.subscriptions.repositories.RoleRepository;

@Service
public class RoleService {
	private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }
    
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
    
}
