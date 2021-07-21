package org.mateuszziebura.krystiantask.domain.security;


import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private boolean logged;
    private Timestamp loginIn;
    private Timestamp loginOut;
}
