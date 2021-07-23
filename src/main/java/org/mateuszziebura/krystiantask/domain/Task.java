package org.mateuszziebura.krystiantask.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;


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
    @Min(1)
    private Integer quantityPlaned;
    private Integer quantityCheckedIn=0;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<History> histories;

}
