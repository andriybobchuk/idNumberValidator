/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 *
 * @author Andriy Bobchuk
 */
public class WrongIdTypeException extends ValidationFailedException {
    
    public WrongIdTypeException(String errorMessage) {
        super(errorMessage);
    }    
}
