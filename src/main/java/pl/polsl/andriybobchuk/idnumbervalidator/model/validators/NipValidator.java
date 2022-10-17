/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.validators;

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
public class NipValidator implements Validator {

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
        checkLength(dashlessToken);
        checkIfNumeric(dashlessToken);
        calculateWeightedSum(dashlessToken);
    }

    /**
     * Checks if the ID entered by the user is or the proper length. If no -
     * throws an InvalidLengthException.
     *
     * @param idToken plain text id token taken directly from user input
     * @throws InvalidLengthException
     */
    private void checkLength(String idToken) throws InvalidLengthException {

        int NIP_LENGTH = 10;

        if (idToken.length() != NIP_LENGTH) {
            throw new InvalidLengthException("Token is of wrong length");
        }
    }

    /**
     * Checks if the ID entered by the user is fully numeric. If no - throws a
     * NonNumericTokenException.
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
     * Using a formula calculates if the ID provided by the user is a valid NIP.
     * If no, throws ValidationFailedException.
     * <p>
     * Algorithm(formula) taken from:
     * <a href="https://aleo.com/pl/funkcje/baza-firm/wyszukiwarka-nip">link</a>
     *
     *
     * @param idToken plain text id token taken directly from user input.
     * @throws ValidationFailedException
     */
    private void calculateWeightedSum(String idToken) throws ValidationFailedException {

        int result = 0;
        int[] weights = new int[]{6, 5, 7, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i <= 8; i++) {
            result += weights[i] * Integer.parseInt(
                    String.valueOf(idToken.charAt(i))
            );
        }
        result %= 11;

        if (result == 10) {
            throw new ValidationFailedException("Failed to calculate weighted sum");
        }
    }
}
