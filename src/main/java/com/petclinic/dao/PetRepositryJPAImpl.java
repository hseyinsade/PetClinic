package com.petclinic.dao;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository("petRepository")
public class PetRepositryJPAImpl implements PetRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Pet findById(Long id) {
        return entityManager.find(Pet.class,id);
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return entityManager.createQuery("from Pet where ownerId=:ownerId",Pet.class)
                .setParameter("ownerId",ownerId)
                .getResultList();
    }

    @Override
    public void create(Pet per) {
        entityManager.persist(per);
    }

    @Override
    public Pet update(Pet pet) {
        return entityManager.merge(pet);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Pet.class,id));
    }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        entityManager.createQuery("from Pet where ownerId=:ownerId",Pet.class)
                .setParameter("ownerId",ownerId)
                .executeUpdate()    ;

    }
}
