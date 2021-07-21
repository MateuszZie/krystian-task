package org.mateuszziebura.krystiantask.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Integer orderNumber;
    private Timestamp orderDeadline;
    private Integer quantityPlaned;
    private Integer quantityCheckedIn;

}
