package com.petclinic.service;

import com.petclinic.exception.OwnerNotFoundExeption;
import com.petclinic.model.Owner;
import com.petclinic.model.Pet;

import java.util.List;

public interface PetclinicService {
    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner (Long id) throws OwnerNotFoundExeption;
    void createOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Long id);

    Pet findPetById(Long id);
    List<Pet> findPetsByOwnerId(Long ownerId);
    void createPet(Pet pet);
    Pet updatePet(Pet pet);
    void deletePet(Long id);
}
