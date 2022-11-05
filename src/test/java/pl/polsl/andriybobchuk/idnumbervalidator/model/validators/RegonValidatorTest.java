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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 *
 * @author Andriy Bobchuk
 */
public class RegonValidatorTest {
    
    public RegonValidatorTest() {
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

    @ParameterizedTest
    @ValueSource(strings = {"123456785", "12345678512347"})
    public void validateValidRegon_succeeds(String idToken) {
        System.out.println("validate regon");
        RegonValidator instance = new RegonValidator();
        
        try {
            instance.validate(idToken);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"123456789", "12345678512349"})
    public void validateWrongRegon_throws(String idToken) {
        System.out.println("validate regon");
        NipValidator instance = new NipValidator();
        
        assertThrows(
                ValidationFailedException.class,
                () -> instance.validate(idToken));

    }
    
}
