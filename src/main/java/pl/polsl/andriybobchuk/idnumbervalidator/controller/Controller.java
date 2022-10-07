/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.andriybobchuk.idnumbervalidator.controller;

import pl.polsl.andriybobchuk.idnumbervalidator.model.IdFactory;
import pl.polsl.andriybobchuk.idnumbervalidator.model.ValidatorFactory;
import pl.polsl.andriybobchuk.idnumbervalidator.model.ids.Id;
import pl.polsl.andriybobchuk.idnumbervalidator.model.validators.Validator;
import pl.polsl.andriybobchuk.idnumbervalidator.view.View;

/**
 *
 * @author Andriy Bobchuk
 */
public class Controller {

    public static void main(String[] args) {

        View view = new View();
        String idTypeToken = view.getIdType();
        String idToken = view.getId();
       
        ValidatorFactory validatorFactory = new ValidatorFactory();
        Validator validator = validatorFactory.getValidator(
                idTypeToken, 
                idToken
        );
        validator.validate();
        if(validator.isValidationSuccessful()) {
            IdFactory idFactory = new IdFactory();
            Id id = idFactory.getId(idTypeToken, idToken);
            view.displayValidationIsSuccessful();
            view.displayIdData(id.toString());
        } else {
            view.displayValidationIsFailed()
        }  
    }
}
