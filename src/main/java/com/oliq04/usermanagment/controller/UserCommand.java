package com.oliq04.usermanagment.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@AllArgsConstructor
@Getter
public class UserCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateOfRegistration;
}
