package org.mateuszziebura.krystiantask.domain;

import lombok.*;
import org.mateuszziebura.krystiantask.domain.security.User;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class History {

    private Integer orderNumber;
    private Timestamp checkIn;
    private User user;
    public Integer quantity;
}
