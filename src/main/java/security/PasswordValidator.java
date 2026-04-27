package security;

public class PasswordValidator {

    public boolean tieneLongitudMinima(String password) {
        validarNoNull(password);
        return password.length() >= 8;
    }

    public boolean contieneNumero(String password) {
        validarNoNull(password);
        for (char caracter : password.toCharArray()) {
            if (Character.isDigit(caracter)) {
                return true;
            }
        }
        return false;
    }

    public boolean contieneMayuscula(String password) {
        validarNoNull(password);
        for (char caracter : password.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                return true;
            }
        }
        return false;
    }

    public boolean contieneCaracterEspecial(String password) {
        validarNoNull(password);
        for (char caracter : password.toCharArray()) {
            if (!Character.isLetterOrDigit(caracter)) {
                return true;
            }
        }
        return false;
    }

    public String reglaQueFallo(String password) {
        validarNoNull(password);

        if (!tieneLongitudMinima(password)) {
            return "La contraseña debe tener al menos 8 caracteres";
        }
        if (!contieneNumero(password)) {
            return "La contraseña debe contener al menos un número";
        }
        if (!contieneMayuscula(password)) {
            return "La contraseña debe contener al menos una letra mayúscula";
        }
        if (!contieneCaracterEspecial(password)) {
            return "La contraseña debe contener al menos un carácter especial";
        }
        return "La contraseña es válida";
    }

    public boolean esPasswordValida(String password) {
        validarNoNull(password);
        return tieneLongitudMinima(password)
                && contieneNumero(password)
                && contieneMayuscula(password)
                && contieneCaracterEspecial(password);
    }

    private void validarNoNull(String password) {
        if (password == null) {
            throw new IllegalArgumentException("La contraseña no puede ser null");
        }
    }
}