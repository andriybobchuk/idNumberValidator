/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.InvalidLengthException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.NonNumericTokenException;

/**
 * Implementation of a Validator interface designed to determine whether 
 * the given PESEL provided by the user is correct or not. In case it is 
 * invalid, throws a general ValidationFailedException with a reference 
 * to a specific child exception class and its description.
 *
 * @author Andriy Bobchuk
 */
public class PeselValidator implements Validator {

    /**
     * Runs all the necessary functions to validate the PESEL. Each individual 
     * function may throw own exception to indicate the problem.
     * 
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException 
     */
    @Override
    public void validate(String idToken) throws ValidationFailedException {

        checkLength(idToken);
        checkIfNumeric(idToken);
        calculateWeightedSum(idToken);
    }
    
    /**
     * Checks if the ID entered by the user is or the proper length. If no - 
     * throws an InvalidLengthException. 
     * 
     * @param idToken plain text id token taken directly from user input
     * @throws InvalidLengthException
     */
    private void checkLength(String idToken) throws InvalidLengthException {

        int PESEL_LENGTH = 11;

        if (idToken.length() != PESEL_LENGTH) {
            throw new InvalidLengthException("Token is of wrong length");
        }
    }

    /**
     * Checks if the ID entered by the user is fully numeric. If no -
     * throws a NonNumericTokenException.
     * 
     * @param idToken plain text id token taken directly from user input
     * @throws NonNumericTokenException 
     */
    private void checkIfNumeric(String idToken) throws NonNumericTokenException {

        if (!idToken.chars().allMatch(Character::isDigit)) {
            throw new NonNumericTokenException("Token is not numeric");
        }
    }

    /**
     * Using a formula calculates if the ID provided by the user is a valid 
     * PESEL. If no, throws ValidationFailedException.
     * <p>
     * Formula: 
     * (9*y1 + 7*y2) + (3*m1 + m2) + (9*d1 + 7*d2) + (3*s1 + s2 + 9*s3 + 7*s4) % 10
     * 
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException 
     */
    private void calculateWeightedSum(String idToken) throws ValidationFailedException {

        int result = 0;
        int[] weights = new int[]{9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        for (int i = 0; i <= 9; i++) {
            result += weights[i] * Integer.parseInt(
                    String.valueOf(idToken.charAt(i))
            );
        }
        result %= 10;

        if (result != Integer.parseInt(String.valueOf(idToken.charAt(10)))) {
            throw new ValidationFailedException("Failed to calculate weighted sum");
        }
    }
}
