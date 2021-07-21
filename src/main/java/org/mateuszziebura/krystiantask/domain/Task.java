package org.mateuszziebura.krystiantask.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;
    private Timestamp orderDeadline;
    private Integer quantityPlaned;
    private Integer quantityCheckedIn;

}
