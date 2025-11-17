package com.poly.rivo.infrastructure.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePassword {

    private String email;

    private String password;

    private String newPassword;
}