package com.petclinic;

import com.petclinic.service.PetclinicService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.security.Security;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
public class PetClinicSecurityTestWithInvalidToken {
    @Autowired
    private PetclinicService petclinicService;

    public void setUp(){
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken("user","secret","ROLE_USER");
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

    }
    @After
    public void tearDown(){
        SecurityContextHolder.clearContext();
    }
    @Test
    public void testFindOwners(){
        petclinicService.findOwners();
    }
}
