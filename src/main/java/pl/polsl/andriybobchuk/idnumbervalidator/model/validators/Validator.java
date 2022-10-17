/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 * Interface for all validators of all IDs. 
 * <p>
 * Based on the SOLID principle, in case of adding new functionality by 
 * extending the number of supported ID types, just create a new 
 * implementation for the new ID number type.
 * 
 * @author Andriy Bobchuk
 */
public interface Validator {
    
    /**
     * Public and abstract function to be overriden by implementations of
     * Validator.
     * 
     * @param idToken plain text ID provided by the user.
     * @throws ValidationFailedException 
     */
    void validate(String idToken) throws ValidationFailedException;
    
}
