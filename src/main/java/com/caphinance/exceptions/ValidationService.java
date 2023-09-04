package com.caphinance.exceptions;

import com.caphinance.exceptions.InvalidDataException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.regex.Pattern;

@Service
public class ValidationService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9.()-]{7,15}$"); // Esto es un ejemplo simple.

    // Método para validar la dirección de email
    public void validateEmail(String email) throws InvalidDataException {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidDataException("Invalid email format.");
        }
    }

    // Método para validar password hash (esto es un ejemplo simple, la validación podría ser más exhaustiva)
    public void validatePasswordHash(String passwordHash) throws InvalidDataException {
        if (passwordHash == null || passwordHash.length() < 8) {
            throw new InvalidDataException("Password hash is too short or null.");
        }
    }

    // Método para validar nombres y apellidos
    public void validateName(String name) throws InvalidDataException {
        if (name == null || name.length() > 50 || !name.matches("[A-Za-z]*")) {
            throw new InvalidDataException("Name is invalid.");
        }
    }

    // Método para validar la fecha de nacimiento
    public void validateDateOfBirth(Date dob) throws InvalidDataException {
        if (dob == null || dob.after(new Date())) {
            throw new InvalidDataException("Date of birth is invalid.");
        }
    }

    // Método para validar el país
    public void validateCountry(String country) throws InvalidDataException {
        // Aquí podrías tener una lista de países admitidos y validar contra ella.
        if (country == null || country.length() > 50) {
            throw new InvalidDataException("Country is invalid.");
        }
    }

    // Método para validar la dirección
    public void validateAddress(String address) throws InvalidDataException {
        if (address != null && address.length() > 200) { // Asumiendo que la dirección puede ser opcional.
            throw new InvalidDataException("Address is too long.");
        }
    }

    // Método para validar el código postal (esto es un ejemplo simple y deberías adaptarlo según tus necesidades)
    public void validatePostalCode(String postalCode) throws InvalidDataException {
        if (postalCode != null && (postalCode.length() < 5 || postalCode.length() > 10)) {
            throw new InvalidDataException("Postal code is invalid.");
        }
    }

    // Método para validar el número de teléfono
    public void validatePhoneNumber(String phoneNumber) throws InvalidDataException {
        if (phoneNumber == null || !PHONE_PATTERN.matcher(phoneNumber).matches()) {
            throw new InvalidDataException("Phone number is invalid.");
        }
    }
}
