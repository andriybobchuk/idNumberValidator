/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 *
 * @author Andriy Bobchuk
 */
public class NipValidatorTest {
    
    public NipValidatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void validateValidNip_succeeds() {
        System.out.println("validate nip");
        String idToken = "1234563218";
        NipValidator instance = new NipValidator();
        
        try {
            instance.validate(idToken);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }
    
    @Test
    public void validateWrongNip_throws() {
        System.out.println("validate nip");
        String idToken = "5555555550";
        NipValidator instance = new NipValidator();
        
        assertThrows(
                ValidationFailedException.class,
                () -> instance.validate(idToken));

    }
    
}
