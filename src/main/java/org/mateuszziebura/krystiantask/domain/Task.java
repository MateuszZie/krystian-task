package org.mateuszziebura.krystiantask.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;
    @NotBlank
    private String orderDeadline;
    @NonNull
    @Min(0)
    private Integer quantityPlaned;
    @NonNull
    @Min(0)
    private Integer quantityCheckedIn;

}
