package org.mateuszziebura.krystiantask.domain;

import lombok.*;
import org.mateuszziebura.krystiantask.domain.security.User;

import javax.persistence.*;
import java.sql.Timestamp;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Task task;
    private Timestamp checkIn;
    public Integer quantity;
    private String userName;
}
