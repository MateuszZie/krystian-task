package org.mateuszziebura.krystiantask.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Data {

    @NotBlank
    private String id;
    @NonNull
    @Min(1)
    private Integer quantity;
}
