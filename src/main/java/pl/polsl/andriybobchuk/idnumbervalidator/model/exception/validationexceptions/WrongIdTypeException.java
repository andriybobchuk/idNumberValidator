/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions;


/**
 * Indicates wrong ID type provided by the user
 * 
 * @author Andriy Bobchuk
 */
public class WrongIdTypeException extends ValidationFailedException {
    
    public WrongIdTypeException(String errorMessage) {
        super(errorMessage);
    }    
}
