/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model;

import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.WrongIdTypeException;
import pl.polsl.andriybobchuk.idnumbervalidator.model.validators.*;

/**
 *
 * @author Andriy Bobchuk
 */
public class ValidatorFactory {
    
   public Validator getValidator(String idType) throws WrongIdTypeException{
      if(idType == null){
         return null;
      }		
      // TODO: Add constants file
      if(idType.equalsIgnoreCase("PESEL")){
         return new PeselValidator(); 
      } else if(idType.equalsIgnoreCase("NIP")){
         return new NipValidator(); 
      } else if(idType.equalsIgnoreCase("REGON")){
         return new RegonValidator();
      } else {
          throw new WrongIdTypeException("Wrong ID type");
      }
   }
    
}
