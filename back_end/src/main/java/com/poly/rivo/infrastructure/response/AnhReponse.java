package com.poly.rivo.infrastructure.response;

import com.poly.rivo.entity.Images;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Images.class})
public interface AnhReponse {
    Long getId();

    String getName();
}
