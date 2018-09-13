package com.petclinic;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTests {
    @Test
    public void genereteEncodedPasswords(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("{bcrypt}"+bCryptPasswordEncoder.encode("secret"));
        System.out.println("{bcrypt}"+bCryptPasswordEncoder.encode("secret"));
        System.out.println("{bcrypt}"+bCryptPasswordEncoder.encode("secret"));
    }
}
