package com.petclinic;

import com.petclinic.model.Owner;
import javafx.scene.control.Alert;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetClinicRestControllerTest {
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }
    @Test
    public void testGetOwnerById(){
        ResponseEntity<Owner> response =  restTemplate.getForEntity("http://localhost:1111/rest/owner/1",Owner.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getFirstName(),Matchers.equalTo("Kenan"));
    }
    @Test
    public void testGetOwnersByLastName(){
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:1111/rest/owner?ln=Sevindik",List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(),Matchers.equalTo(200));
        List<Map<String,String>> body = response.getBody();
        List<String> firstNames =  body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
        MatcherAssert.assertThat(firstNames,Matchers.containsInAnyOrder("Kenan","Hümeyra","Salim"));
    }
    @Test
    public void testGetOwners(){
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:1111/rest/owners",List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(),Matchers.equalTo(200));
        List<Map<String,String>> body = response.getBody();
        List<String> firstNames =  body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
        MatcherAssert.assertThat(firstNames,Matchers.containsInAnyOrder("Kenan","Hümeyra","Salim","Muammer"));
    }
    @Test
    public void testCreateOwner(){
        Owner owner = new Owner();
        owner.setFirstName("Metehan");
        owner.setLastName("Yücel");
        URI location = restTemplate.postForLocation("http://localhost:1111/rest/owner",owner);
        Owner owner2 = restTemplate.getForObject(location,Owner.class);
        MatcherAssert.assertThat(owner2.getFirstName(),Matchers.equalTo(owner.getFirstName()));
        MatcherAssert.assertThat(owner2.getLastName(),Matchers.equalTo(owner.getLastName()));
    }
    @Test
    public void testUpdateOwner(){
        Owner owner = restTemplate.getForObject("http://localhost:1111/rest/owner/1",Owner.class);
        owner.setFirstName("Emre");
        restTemplate.put("http://localhost:1111/rest/owner",owner);
        ResponseEntity<Owner> owner1 = restTemplate.getForEntity("http://localhost:1111/rest/owner/1",Owner.class);
        MatcherAssert.assertThat(owner1.getStatusCodeValue(),Matchers.equalTo(200));
        MatcherAssert.assertThat(owner1.getBody().getFirstName(),Matchers.equalTo("Emre"));
    }
    @Test
    public void testDeletOwner(){
        restTemplate.delete("http://localhost:1111/rest/owner/1");

    }
}
