/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.andriybobchuk.idnumbervalidator.model;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.polsl.andriybobchuk.idnumbervalidator.model.exception.validationexceptions.ValidationFailedException;

/**
 *
 * @author Andriy Bobchuk
 */
public class BaseBusinessLogicTest {

    @Test
    public void checkLength_withCorrectInput_succeeds() {
        System.out.println("checkLength");
        String token = "123456789";
        int requiredLength = 9;

        try {
            new BaseBusinessLogic().checkLength(token, requiredLength);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }

    @Test
    public void checkLength_withWrongInput_throws() {
        System.out.println("checkLength");
        String token = "123456789";
        int requiredLength = 10;

        assertThrows(
                ValidationFailedException.class,
                () -> new BaseBusinessLogic().checkLength(token, requiredLength)
        );
    }

    @Test
    public void checkIfNumeric_withNumericInput_succeeds() {
        System.out.println("checkIfNumeric");
        String token = "123456789";

        try {
            new BaseBusinessLogic().checkIfNumeric(token);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }

    @Test
    public void checkIfNumeric_withNonNumericInput_throws() {
        System.out.println("checkIfNumeric");
        String token = "123a56789";

        assertThrows(
                ValidationFailedException.class,
                () -> new BaseBusinessLogic().checkIfNumeric(token));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForCheckWeightedSumWithCorrectInput")
    public void checkWeightedSum_withCorrectInput_succeeds(String idToken, int modValue, int... weights) {
        System.out.println("checkWeightedSum");
        try {
            new BaseBusinessLogic().checkWeightedSum(idToken, modValue, weights);
        } catch (ValidationFailedException e) {
            fail("Exception thrown.");
        }
    }

    private static Stream<Arguments> provideStringsForCheckWeightedSumWithCorrectInput() {
        return Stream.of(
                // Correct PESEL:
                Arguments.of("02292110731", 10, new int[]{9, 7, 3, 1, 9, 7, 3, 1, 9, 7}),
                // Correct NIP (without dashes cause they are removed by controller):
                Arguments.of("1234563218", 11, new int[]{6, 5, 7, 2, 3, 4, 5, 6, 7}),
                // Correct 9-digit REGON:
                Arguments.of("123456785", 11, new int[]{8, 9, 2, 3, 4, 5, 6, 7}),
                // Correct 14-digit REGON:
                Arguments.of("12345678512347", 11, new int[]{2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForCheckWeightedSumWithWrongInput")
    public void checkWeightedSum_withWrongInput_fails(String idToken, int modValue, int... weights) {
        System.out.println("checkWeightedSum");

        assertThrows(
                ValidationFailedException.class,
                () -> new BaseBusinessLogic().checkWeightedSum(idToken, modValue, weights));
    }

    private static Stream<Arguments> provideStringsForCheckWeightedSumWithWrongInput() {
        return Stream.of(
                // Wrong PESEL:
                Arguments.of("02292110733", 10, new int[]{9, 7, 3, 1, 9, 7, 3, 1, 9, 7}),
                // Wrong NIP (without dashes cause they are removed by controller):
                Arguments.of("5555555550", 11, new int[]{6, 5, 7, 2, 3, 4, 5, 6, 7}),
                // Wrong 9-digit REGON:
                Arguments.of("123456789", 11, new int[]{8, 9, 2, 3, 4, 5, 6, 7}),
                // Wrong 14-digit REGON:
                Arguments.of("12345678512349", 11, new int[]{2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8})
        );
    }
}
