/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import pl.polsl.andriybobchuk.idnumbervalidator.model.BaseBusinessLogic;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 * Implementation of a Validator interface designed to determine whether 
 * the given PESEL provided by the user is correct or not. In case it is 
 * invalid, throws a general ValidationFailedException with a reference 
 * to a specific child exception class and its description.
 *
 * @author Andriy Bobchuk
 */
public class PeselValidator extends BaseBusinessLogic implements Validator {

    /**
     * Runs all the necessary functions to validate the PESEL. Each individual 
     * function may throw own exception to indicate the problem.
     * 
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException 
     */
    @Override
    public void validate(String idToken) throws ValidationFailedException {
        checkLength(idToken, 11);
        checkIfNumeric(idToken);
        checkWeightedSum(idToken, 10, 9, 7, 3, 1, 9, 7, 3, 1, 9, 7);
    }
}
