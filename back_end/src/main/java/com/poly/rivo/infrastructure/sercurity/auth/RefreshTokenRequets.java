package com.poly.rivo.infrastructure.sercurity.auth;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RefreshTokenRequets {
    private String token;
}
