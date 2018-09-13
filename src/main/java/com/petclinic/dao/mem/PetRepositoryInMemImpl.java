package com.petclinic.dao.mem;

import com.petclinic.dao.PetRepository;
import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PetRepositoryInMemImpl implements PetRepository {

    private Map<Long,Pet> petMap = new HashMap<>();
    PetRepositoryInMemImpl(){
        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setName("pet1");
        pet1.setBirthDay(new Date());
        pet1.setOwner(new Owner());
        pet1.getOwner().setId(1L);

        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setName("pet2");
        pet2.setBirthDay(new Date());
        pet1.setOwner(new Owner());
        pet1.getOwner().setId(2L);


        Pet pet3 = new Pet();
        pet3.setId(3L);
        pet3.setName("pet3");
        pet3.setBirthDay(new Date());
        pet1.setOwner(new Owner());
        pet1.getOwner().setId(3L);

        Pet pet4 = new Pet();
        pet4.setId(4L);
        pet4.setName("pet4");
        pet4.setBirthDay(new Date());
        pet1.setOwner(new Owner());
        pet1.getOwner().setId(4L);

        petMap.put(pet1.getId(),pet1);
        petMap.put(pet2.getId(),pet2);
        petMap.put(pet3.getId(),pet3);
        petMap.put(pet4.getId(),pet4);
    }

    @Override
    public Pet findById(Long id) {
        return petMap.get(id);
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return petMap.values().stream().filter(pet -> pet.getOwner().getId().equals(ownerId)).collect(Collectors.toList());
    }

    @Override
    public void create(Pet per) {
        Pet pet = new Pet();
        pet.setId(new Date().getTime());
        petMap.put(pet.getId(),pet);
    }

    @Override
    public Pet update(Pet pet) {
        petMap.replace(pet.getId(),pet);
        return pet;
    }

    @Override
    public void delete(Long id) {
        petMap.remove(id);
    }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        petMap.values().stream().filter(pet -> pet.getOwner().getId().equals(ownerId)).collect(Collectors.toList()).forEach(pet->{
            petMap.remove(pet.getId());
        });
    }
}
