package com.daw.segurhogar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
