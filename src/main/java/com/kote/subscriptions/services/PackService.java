package com.kote.subscriptions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kote.subscriptions.models.Pack;
import com.kote.subscriptions.repositories.PackRepository;

@Service
public class PackService {
	private final PackRepository packRepo;

    public PackService(PackRepository packRepo) {
        this.packRepo = packRepo;
    }

	public List<Pack> allPackages() {
        return packRepo.findAll();
	}

	 public Pack createPack(Pack pack) {
	    	return packRepo.save(pack);
	    }

	public Pack findById(Long id) {
    	Optional<Pack> p = packRepo.findById(id);
		if(p.isPresent()) {
            return p.get();
    	} else {
    	    return null;
    	}
	}

	public Pack updatePack(Long id, Long cost) {
        Pack pack = packRepo.findById(id).orElse(new Pack());
        pack.setCost(cost);
        return packRepo.save(pack);
    }

	public Pack updatePack(Pack pack) {	
		return pack;
	}

	public void deletePack(Long id) {
    	packRepo.deleteById(id);		
	}

	public Pack findByName(String name) {
		return packRepo.findByName(name);
	}
}
