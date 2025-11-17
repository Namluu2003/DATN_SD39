package com.poly.rivo.infrastructure.sercurity.config;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountDetalsService {

    UserDetailsService userDetailsService();
}
