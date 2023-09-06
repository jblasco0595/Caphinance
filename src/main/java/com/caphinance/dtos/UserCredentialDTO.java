package com.caphinance.dtos;

import lombok.Data;

@Data
public class UserCredentialDTO {
    private Long credentialId;
    private Long userId;
    private String passwordHash;
    private String accessToken;
    private String refreshToken;
}
