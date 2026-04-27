# PasswordValidatorTesting

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven)
![JUnit 5](https://img.shields.io/badge/JUnit%205-25A162?style=for-the-badge&logo=junit5)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

Proyecto Maven en Java 21 que implementa una clase para validar contraseñas y pruebas unitarias con JUnit 5.

## Descripción

Este proyecto valida contraseñas según estas reglas:

- No puede ser `null`.
- Debe tener al menos 8 caracteres.
- Debe contener al menos un número.
- Debe contener al menos una letra mayúscula.

## Estructura del proyecto

```text
src/
├── main/
│   └── java/
│       └── security/
│           └── PasswordValidator.java
└── test/
    └── java/
        └── security/
            └── PasswordValidatorTest.java
```

## Requisitos

- Java JDK 21.
- Maven.
- IntelliJ IDEA o cualquier IDE compatible con Maven.

## Ejecución de pruebas

Para correr las pruebas unitarias:

```bash
mvn test
```

## Métodos implementados

- `tieneLongitudMinima(String password)`
- `contieneNumero(String password)`
- `contieneMayuscula(String password)`
- `esPasswordValida(String password)`

## Autor
 Los promp-gramadores.
 <img src="assets/WhatsApp-Image-2026-04-15-at-23.01.49.jpg" alt="Los Prompt-Gramadores" width="400"/>
