/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.InvalidLengthException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.NonNumericTokenException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 * BaseBusinessLogic functions that are frequently used
 *
 * @author Andriy Bobchuk
 */
public class BaseBusinessLogic {

    /**
     * Checks if the token entered by the user is or the proper length.If no -
     * throws an InvalidLengthException.
     *
     * @param token plain text token taken directly from user input
     * @param requiredLength
     * @throws InvalidLengthException
     */
    public void checkLength(String token, int requiredLength) throws InvalidLengthException {
        if (token.length() != requiredLength) {
            throw new InvalidLengthException("Token is of wrong length");
        }
    }

    /**
     * Checks if the token entered by the user is fully numeric. If no - throws
     * a NonNumericTokenException.
     *
     * @param token plain text id token taken directly from user input
     * @throws NonNumericTokenException
     */
    public void checkIfNumeric(String token) throws NonNumericTokenException {

        if (!token.chars().allMatch(Character::isDigit)) {
            throw new NonNumericTokenException("Token is not numeric");
        }
    }

    /**
     * Compares the control number with the result of performed weighted sum
     * calculation.
     *
     * @param idToken ID number of any class.
     * @param modValue value division by which we want to get the rest.
     * @param weights weights to multiply by the numbers of ID
     * @throws pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException
     */
    public void checkWeightedSum(
            String idToken,
            int modValue,
            int... weights
    ) throws ValidationFailedException {

        List<Integer> weightsList = new ArrayList<>();
        weightsList = Arrays.stream(weights).boxed().toList();
        
        int result = 0;
        int it = 0;
        for (Integer element : weightsList) {
            result += element * Integer.valueOf(String.valueOf(idToken.charAt(it)));
            it++;
        }

        result %= modValue;
        int controlValue = Integer.parseInt(String.valueOf(idToken.charAt(idToken.length() - 1))); // Last element
        
        if (result != controlValue) {
            throw new ValidationFailedException("Failed to calculate weighted sum");
        }
    }
}
