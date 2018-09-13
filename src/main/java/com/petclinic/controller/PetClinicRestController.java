package com.petclinic.controller;

import com.petclinic.exception.OwnerNotFoundExeption;
import com.petclinic.model.Owner;
import com.petclinic.service.PetclinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {

    @Autowired
    private PetclinicService petclinicService;

    @GetMapping(value = "/owners")
    public ResponseEntity<?> getOwners(){
        return ResponseEntity.ok(petclinicService.findOwners());
    }

    @GetMapping(value = "/owner")
    public ResponseEntity<?> getOwners(@RequestParam("ln") String lastName){
        return ResponseEntity.ok(petclinicService.findOwners(lastName));
    }
    @GetMapping("/owner/{id}")
    public ResponseEntity<?> getOwner(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(petclinicService.findOwner(id));
        }catch (OwnerNotFoundExeption e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/owner")
    public ResponseEntity<URI> createOwner(@RequestBody Owner owner){
        try {
            petclinicService.createOwner(owner);
            Long id = owner.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/owner")
    public ResponseEntity<?> updateOwner(@RequestBody Owner owner){
        try{
            petclinicService.updateOwner(owner);
            return ResponseEntity.ok().build();
        }catch (OwnerNotFoundExeption e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/owner/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id){
        try{
            petclinicService.deleteOwner(id);
            return ResponseEntity.ok().build();
        }catch (OwnerNotFoundExeption e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
