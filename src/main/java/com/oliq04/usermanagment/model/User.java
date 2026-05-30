package com.oliq04.usermanagment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateOfRegistration;
}
