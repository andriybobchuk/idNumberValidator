/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions;

/**
 * Indicates the general problem occuring while parsing.
 * 
 * @author Andriy Bobchuk
 */
public class ParsingFailedException extends Exception {
    
    public ParsingFailedException(String errorMessage) {
        super(errorMessage);
    }
}
