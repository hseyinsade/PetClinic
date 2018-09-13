package com.petclinic.service;


import com.petclinic.dao.OwnerRepository;
import com.petclinic.dao.PetRepository;
import com.petclinic.exception.OwnerNotFoundExeption;
import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PetclinicServiceImpl implements PetclinicService {
    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Secured(value = {"ROLE_USER","ROLE_EDITOR"})
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Owner findOwner(Long id) throws OwnerNotFoundExeption {
        Owner owner = ownerRepository.findById(id);
        if(null == owner) throw new OwnerNotFoundExeption("Owner not found with id : " + id);
        return owner;
    }
    @Override
    public void createOwner(Owner owner) {
        ownerRepository.create(owner);
    }
    @Override
    public void updateOwner(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.delete(id);
    }

    @Override
    public Pet findPetById(Long id) {
        return null;
    }

    @Override
    public List<Pet> findPetsByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void createPet(Pet pet) {

    }

    @Override
    public Pet updatePet(Pet pet) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }
}
