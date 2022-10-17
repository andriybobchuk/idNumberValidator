/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.ids;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions.ParsingFailedException;

/**
 * Represents a PESEL identifier.
 *
 * @author Andriy Bobchuk
 * @version 1.2
 */
public class Pesel implements Id {

    private final String identifier;
    private String birthDate;
    private String gender = "Male";

    /**
     * Constructor, calls parse function to set all its properties and prepare
     * the object for future operations. In case of any error throws
     * ParsingFailedException
     *
     * @param identifier ID token to be parsed
     * @throws ParsingFailedException
     */
    public Pesel(String identifier) throws ParsingFailedException {
        this.identifier = identifier;
        parseToken();
    }

    /**
     * According to Single Responsibility Principle, parseToken is split into
     * parseBirthDate and parseGender.
     *
     * @throws ParsingFailedException
     */
    private void parseToken() throws ParsingFailedException {
        parseBirthDate();
        parseGender();
    }

    /**
     * Parses birth date according to the algorithm provided here:
     * <a href="https://calculla.com/poland_pesel_decoder">link</a>
     *
     * @throws ParsingFailedException
     */
    private void parseBirthDate() throws ParsingFailedException {
        String yearShort = identifier.substring(0, 2);
        String yearFull;

        int month = Integer.parseInt(identifier.substring(2, 4));
        if (month >= 1 && month <= 12) {
            yearFull = "19" + yearShort;
        } else if (month >= 21 && month <= 32) {
            yearFull = "20" + yearShort;
            month -= 20;
        } else {
            throw new ParsingFailedException("We don't work with people born before XX or after XXI century.");
        }

        String day = identifier.substring(4, 6);

        this.birthDate = day + "." + month + "." + yearFull;
    }

    /**
     * Parses gender according to the algorithm provided here:
     * <a href="https://calculla.com/poland_pesel_decoder">link</a>
     *
     * @throws ParsingFailedException
     */
    private void parseGender() {

        final int GENDER_CODE_POSITION = 9;

        if (Integer.valueOf(identifier.charAt(GENDER_CODE_POSITION)) % 2 == 0) {
            this.gender = "Female";
        }
    }

    @Override
    public String toString() {
        return "Birth Date: " + birthDate + "\nGender: " + gender;
    }
}
