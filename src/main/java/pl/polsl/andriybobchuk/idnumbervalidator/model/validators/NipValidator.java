/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import pl.polsl.andriybobchuk.idnumbervalidator.model.BaseBusinessLogic;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.InvalidLengthException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.NonNumericTokenException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 * Implementation of a Validator interface designed to determine whether the
 * given NIP provided by the user is correct or not. In case it is invalid,
 * throws a general ValidationFailedException with a reference to a specific
 * child exception class and its description.
 *
 * @author Andriy Bobchuk
 */
public class NipValidator extends BaseBusinessLogic implements Validator {

    /**
     * Runs all the necessary functions to validate the NIP. Each individual
     * function may throw own exception to indicate the problem.
     *
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException
     */
    @Override
    public void validate(String idToken) throws ValidationFailedException {

        String dashlessToken = idToken.replaceAll("\\-", "");
        checkLength(dashlessToken, 10);
        checkIfNumeric(dashlessToken);
        checkWeightedSum(dashlessToken, 11, 6, 5, 7, 2, 3, 4, 5, 6, 7);
    }
}
