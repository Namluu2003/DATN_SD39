package com.poly.rivo.service;

import com.poly.rivo.infrastructure.request.ChangePassword;
import com.poly.rivo.infrastructure.request.ResetPassword;
import com.poly.rivo.infrastructure.sercurity.auth.JwtAuhenticationResponse;
import com.poly.rivo.infrastructure.sercurity.auth.SignUpRequets;
import com.poly.rivo.infrastructure.sercurity.auth.SigninRequest;

public interface AuthenticationService {
    String signUp(SignUpRequets signUpRequets);

    JwtAuhenticationResponse singIn(SigninRequest request);

    String resetPassword(ResetPassword resetPassword);

    String changePassword (ChangePassword changePassword);
}
