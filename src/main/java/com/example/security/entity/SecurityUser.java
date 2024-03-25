package com.example.security.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SecurityUser {
    private String uid;
    private String pwd;
    private String uname;
    private String email;
    private LocalDate regDate;
    private int isDeleted;
    private String picture;
    private String provider;
    private String role;
}
