package com.petclinic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "petclinic")
public class PetclinicProperties {
    private boolean displayOwnerWithPets = false;

    public boolean isDisplayOwnerWithPets() {
        return displayOwnerWithPets;
    }

    public void setDisplayOwnerWithPets(boolean displayOwnerWithPets) {
        this.displayOwnerWithPets = displayOwnerWithPets;
    }
}
