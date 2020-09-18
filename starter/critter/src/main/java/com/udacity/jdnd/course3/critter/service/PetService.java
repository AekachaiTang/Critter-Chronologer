package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return this.petRepository.save(pet);
    }

    public Pet findById(Long id){
        return this.petRepository.findById(id).get();
    }

    public List<Pet> findAll() {
        return this.petRepository.findAll();
    }

    public List<Pet> findPetByOwnerId(Long id){
        return this.petRepository.findAllByCustomerId(id);
    }
}
