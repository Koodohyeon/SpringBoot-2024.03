package com.example.security.entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    private int mid;
    private String name;
    private LocalDate regDate;
    private String email;
}
