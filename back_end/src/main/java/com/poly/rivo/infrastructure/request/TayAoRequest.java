package com.poly.rivo.infrastructure.request;

import com.poly.rivo.infrastructure.common.PageableRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TayAoRequest extends PageableRequest {
    private Long id;
    @NotEmpty(message = "Tay áo không được để trống")
    private String name;
    private Boolean status;

}
