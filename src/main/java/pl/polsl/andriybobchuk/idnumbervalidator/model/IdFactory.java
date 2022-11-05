/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions.ParsingFailedException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.ids.*;

/**
 * Provides an ID depending on the user input
 * 
 * @author Andriy Bobchuk
 */
public class IdFactory {

    //use getId method to get object of type id 
    public Id getId(String idType, String identifier) throws ParsingFailedException {
        if (idType == null) {
            return null;
        }
        if (idType.equalsIgnoreCase("PESEL")) {
            return new Pesel(identifier);
        } else if (idType.equalsIgnoreCase("NIP")) {
            return new Nip(identifier);
        } else if (idType.equalsIgnoreCase("REGON")) {
            return new Regon(identifier);
        }
        return null;
    }
}
