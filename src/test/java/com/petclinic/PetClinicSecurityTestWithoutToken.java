package com.petclinic;

import com.petclinic.service.PetclinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.AuthenticationException;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
public class PetClinicSecurityTestWithoutToken {
    @Autowired
    private PetclinicService petclinicService;

    @Test(expected = AuthenticationCredentialsNotFoundException.class )
    public void testFindOwners(){
        petclinicService.findOwners();
    }
}
