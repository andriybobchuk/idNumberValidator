/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import pl.polsl.andriybobchuk.idnumbervalidator.model.BaseBusinessLogic;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 * Implementation of a Validator interface designed to determine whether the
 * given REGON provided by the user is correct or not. In case it is invalid,
 * throws a general ValidationFailedException with a reference to a specific
 * child exception class and its description.
 *
 * @author Andriy Bobchuk
 */
public class RegonValidator extends BaseBusinessLogic implements Validator {

    /**
     * Runs all the necessary functions to validate the REGON. Each individual
     * function may throw own exception to indicate the problem.
     *
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException
     */
    @Override
    public void validate(String idToken) throws ValidationFailedException {

        // Tries to validate the short version, if fails, no problem.
        // Tries to validate the long version, if also fails, throws
        try {
            checkLength(idToken, 9);
            checkIfNumeric(idToken);
            checkWeightedSum(idToken, 11, 8, 9, 2, 3, 4, 5, 6, 7);
        } catch (ValidationFailedException e) {
            checkLength(idToken, 14);
            checkIfNumeric(idToken);
            checkWeightedSum(idToken, 11, 2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8);
        }
    }

}

