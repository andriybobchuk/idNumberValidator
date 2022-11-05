/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.view;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * View class is responsible for all interactions with the user.
 *
 * @author Andriy Bobchuk
 */
public class View {

    private final Scanner scanner;
    public NewJFrame frame;


    public View() {

        frame = new NewJFrame();
        
        //displayWelcomeText();

        scanner = new Scanner(System.in);
    }

    /**
     * Displays welcome text
     */
    private void displayWelcomeText() {
        System.out.println("Welcome to ID number validator!");
        System.out.print("This program validates the following IDs:    ");
        Stream<String> stream;
        stream = Stream.of("Pesel ", "Nip ", "Regon ");
        stream.forEach(System.out::print);
        System.out.println();
    }

    /**
     * @return ID type from user input
     */
    public String getIdType() {
        System.out.println("Type 'PESEL'/'NIP'/'REGON' to validate PESEL/NIP/REGON");
        return scanner.next();
    }

    /**
     * @return ID from user input
     */
    public String getId() {
        System.out.println("Enter the ID");
        return scanner.next();
    }

    /**
     * Displays error message
     */
    public void displayErrorMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays success message
     */
    public void displayValidationIsSuccessful() {
        System.out.println("Validation is successful");
    }

    /**
     * Displays success message
     */
    public void displayParsingIsSuccessful() {
        System.out.println("Parsing is successful");
    }

    /**
     * Displays IDs' data
     * @param toString IdObject.toString()
     */
    public void displayIdData(String toString) {
        System.out.println("Extracted ID data:");
        System.out.println(toString);
    }
    
    public void displayManual() {
        displayWelcomeText();
        System.out.println("Type: \nPESEL\nNIP (separators are not considered) \nREGON (Both 9 and 14 digit)\nto validate and extract the data from an ID of your choice. Case is not significant.");
        System.out.println("Good Luck!");
    }
}
