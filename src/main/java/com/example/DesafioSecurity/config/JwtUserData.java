package com.example.DesafioSecurity.config;

import lombok.Builder;

@Builder
public record JwtUserData(Long userId, String email) {
    
}
