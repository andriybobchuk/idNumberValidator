/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.ids;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions.ParsingFailedException;

/**
 * Represents a NIP identifier.
 *
 * @author Andriy Bobchuk
 * @version 1.2
 */
public class Nip implements Id{
    
    private final String identifier;
    private final String taxOfficePrefix;

    /**
     * Constructor, calls parse function to set all its properties and prepare
     * the object for future operations. In case of any error throws
     * ParsingFailedException
     *
     * @param identifier ID token to be parsed
     */
    public Nip(String identifier) {
        this.identifier = identifier;
        this.taxOfficePrefix = identifier.substring(0,3); // Tax office prefix are the first 3 digits.
    }
    
    @Override
    public String toString() {
        return "Tax office prefix: " + taxOfficePrefix;
    }
}
