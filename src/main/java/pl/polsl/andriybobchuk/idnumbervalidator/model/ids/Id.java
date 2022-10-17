/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model.ids;

/**
 *Interface for all IDs. 
 * <p>
 * Based on the SOLID principle, in case of adding new functionality by 
 * extending the number of supported ID types, just create a new 
 * implementation for the new ID number type.
 * 
 * @author Andriy Bobchuk
 */
public interface Id {
    
    /**
     * Allows outputting the content of ID object to console;
     * 
     * @return the values of object's member variables.
     */
    public String toString();
}
