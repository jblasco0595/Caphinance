package com.caphinance.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserProfileDTO {
    private Long profileId;
    private Long userId;
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String nickname;
    private LocalDate dateOfBirth;
    private String country;
    private String address;
    private String postalCode;
    private String phoneNumber;
}
