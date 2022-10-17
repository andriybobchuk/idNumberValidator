/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.view;

import java.util.Scanner;

/**
 * 
 * @author Andriy Bobchuk
 */
public class View {
    
    private final Scanner scanner;
    
    public View() {
        
        displayWelcomeText();
  
        scanner = new Scanner(System.in);
    }
   
    private void displayWelcomeText() {
        System.out.println("Welcome to ID number validator!");
    }
    
    public String getIdType() {
        System.out.println("Type 'PESEL'/'NIP'/'REGON' to validate PESEL/NIP/REGON");
        return scanner.next();
    }
    
    public String getId() {
        System.out.println("Enter the ID");
        return scanner.next();
    }

    public void displayErrorMessage(String message) {
       System.out.println(message);
    }
    
    public void displayValidationIsSuccessful() {
       System.out.println("Validation is successful");
    }

    public void displayParsingIsSuccessful() {
        System.out.println("Parsing is successful");
    }
    
    public void displayIdData(String toString) {
        System.out.println("Extracted ID data:");
        System.out.println(toString);
    }
}
