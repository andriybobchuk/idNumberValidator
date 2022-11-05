/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.ids;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions.ParsingFailedException;

/**
 * Represents a REGON identifier.
 *
 * @author Andriy Bobchuk
 * @version 1.2
 */
public class Regon implements Id {

    private final String identifier;
    private String territorialDesignation; // common for both 9 and 14 digit REGON
    private String serialNumber; // common for both 9 and 14 digit REGON
    private String localUnitOrdinalNumber; // Property of ONLY Local Unit REGON

    /**
     * Constructor, calls parse function to set all its properties and prepare
     * the object for future operations. In case of any error throws
     * ParsingFailedException
     *
     * @param identifier ID token to be parsed
     * @throws ParsingFailedException
     */
    public Regon(String identifier) throws ParsingFailedException {
        this.identifier = identifier;
        parseToken();
    }

    /**
     * According to Single Responsibility Principle, parseToken is split into
     * parseTerritorialDesignation, parseSerialNumber, and
     * parseLocalUnitOrdinalNumber.
     *
     * @throws ParsingFailedException
     */
    private void parseToken() throws ParsingFailedException {
        parseTerritorialDesignation();
        parseSerialNumber();
        parseLocalUnitOrdinalNumber();
    }

    /**
     * Parses territorialDesignation according to the algorithm provided here:
     * <a href="https://businessinsider.com.pl/biznes/numer-regon-kto-wydaje-ile-ma-cyfr-jak-sprawdzic/xy40j7l">link</a>
     */
    private void parseTerritorialDesignation() {
        territorialDesignation = identifier.substring(0, 2);
    }

    /**
     * Parses serialNumber according to the algorithm provided here:
     * <a href="https://businessinsider.com.pl/biznes/numer-regon-kto-wydaje-ile-ma-cyfr-jak-sprawdzic/xy40j7l">link</a>
     */
    private void parseSerialNumber() {
        serialNumber = identifier.substring(2, 8);
    }

    /**
     * Parses localUnitOrdinalNumber according to the algorithm provided here:
     * <a href="https://businessinsider.com.pl/biznes/numer-regon-kto-wydaje-ile-ma-cyfr-jak-sprawdzic/xy40j7l">link</a>
     */
    private void parseLocalUnitOrdinalNumber() {
        try {
            localUnitOrdinalNumber = identifier.substring(9, 13);
        } catch (StringIndexOutOfBoundsException e) {
            localUnitOrdinalNumber = "Not provided";
        }
    }

    @Override
    public String toString() {
        return "Territorial Designation: " + territorialDesignation + "\nSerial Number: " + serialNumber + "\nLocal unit ordinal number: " + localUnitOrdinalNumber;
    }
}
