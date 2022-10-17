/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.controller;

import pl.polsl.andriybobchuk.idnumbervalidator.model.IdFactory;
import pl.polsl.andriybobchuk.idnumbervalidator.model.ValidatorFactory;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.parsingexceptions.ParsingFailedException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.ids.Id;
import pl.polsl.andriybobchuk.idnumbervalidator.model.validators.Validator;
import pl.polsl.andriybobchuk.idnumbervalidator.view.View;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.WrongIdTypeException;

/**
 *
 * @author Andriy Bobchuk
 */
public class Controller {

    public static void main(String[] args) {

        View view = new View();
        ValidatorFactory validatorFactory = new ValidatorFactory();

        boolean terminate = false;
        while (!terminate) {
            // Remove all whitespaces and non-visible characters:
            String idTypeToken = view.getIdType().replaceAll("\\s+",""); 
            String idToken = view.getId().replaceAll("\\s+","");

            try {
                Validator validator = validatorFactory.getValidator(idTypeToken);
                validator.validate(idToken);
                view.displayValidationIsSuccessful();
                
                IdFactory idFactory = new IdFactory();
                Id id = idFactory.getId(idTypeToken, idToken);
                view.displayParsingIsSuccessful();
                view.displayIdData(id.toString());

                terminate = true;
                
            } catch (ValidationFailedException | ParsingFailedException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }

    }
}
