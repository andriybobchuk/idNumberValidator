/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions;

/**
 *
 * @author Andriy Bobchuk
 */
public class NonNumericTokenException extends ValidationFailedException {
    
    public NonNumericTokenException(String errorMessage) {
        super(errorMessage);
    }
}
