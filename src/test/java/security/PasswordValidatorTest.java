package security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void longitudValida() {
        assertTrue(validator.tieneLongitudMinima("Clave123"));
    }

    @Test
    void longitudInvalida() {
        assertFalse(validator.tieneLongitudMinima("Abc12"));
    }

    @Test
    void contieneNumero() {
        assertTrue(validator.contieneNumero("Clave123"));
    }

    @Test
    void noContieneNumero() {
        assertFalse(validator.contieneNumero("ClaveABC"));
    }

    @Test
    void contieneMayuscula() {
        assertTrue(validator.contieneMayuscula("clave123A"));
    }

    @Test
    void noContieneMayuscula() {
        assertFalse(validator.contieneMayuscula("clave123"));
    }

    @Test
    void contieneCaracterEspecial() {
        assertTrue(validator.contieneCaracterEspecial("Clave123!"));
    }

    @Test
    void noContieneCaracterEspecial() {
        assertFalse(validator.contieneCaracterEspecial("Clave123"));
    }

    @Test
    void passwordCompletaValida() {
        assertTrue(validator.esPasswordValida("Clave123!"));
    }

    @Test
    void passwordInvalida() {
        assertFalse(validator.esPasswordValida("clave123"));
    }

    @Test
    void nullLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> validator.esPasswordValida(null));
    }

    @Test
    void reglaQueFalloLongitud() {
        assertEquals("La contraseña debe tener al menos 8 caracteres", validator.reglaQueFallo("Ab1!"));
    }

    @ParameterizedTest
    @CsvSource({
            "Clave123!, true",
            "clave123!, false",
            "CLAVEABC!, false",
            "Cla12!, false",
            "Clave123, false"
    })
    void testsParametrizadosPasswordValida(String password, boolean esperado) {
        assertEquals(esperado, validator.esPasswordValida(password));
    }

    @ParameterizedTest
    @CsvSource({
            "Clave123!, La contraseña es válida",
            "Ab1!, La contraseña debe tener al menos 8 caracteres",
            "clave123!, La contraseña debe contener al menos una letra mayúscula",
            "ClaveABC!, La contraseña debe contener al menos un número",
            "Clave123, La contraseña debe contener al menos un carácter especial"
    })
    void testsParametrizadosReglaQueFallo(String password, String esperado) {
        assertEquals(esperado, validator.reglaQueFallo(password));
    }
}