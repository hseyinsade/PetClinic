package com.petclinic.dao;

import com.petclinic.model.Pet;

import java.util.List;

public interface PetRepository {

    Pet findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
    void create(Pet per);
    Pet update(Pet pet);
    void delete(Long id);
    void deleteByOwnerId(Long ownerId);
}
