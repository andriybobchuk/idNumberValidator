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
public class PeselValidatorTest {
    
    public PeselValidatorTest() {
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
    public void validateValidPesel_succeeds() {
        System.out.println("validate pesel");
        String idToken = "02292110731";
        PeselValidator instance = new PeselValidator();
        
        try {
            instance.validate(idToken);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }
    
    @Test
    public void validateWrongPesel_throws() {
        System.out.println("validate pesel");
        String idToken = "02292110733";
        PeselValidator instance = new PeselValidator();
        
        assertThrows(
                ValidationFailedException.class,
                () -> instance.validate(idToken));

    }
    
}
